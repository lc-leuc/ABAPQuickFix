package com.abapblog.adt.quickfix.assist.comments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;

import com.abapblog.adt.quickfix.Activator;
import com.abapblog.adt.quickfix.assist.syntax.statements.QuickFIxProposal;
import com.abapblog.adt.quickfix.assist.utility.QuickFixIcon;
import com.abapblog.adt.quickfix.preferences.PreferenceConstants;

public class TranslateCommentToEnglish implements IQuickAssistProcessor {
	AbapQuickFixRemoveCommentsCodeParser commentParser;

	@Override
	public boolean canAssist(IQuickAssistInvocationContext context) {
		if (checkQuickFixAllowed()) {

			commentParser = new AbapQuickFixRemoveCommentsCodeParser();
			String sourceCode = context.getSourceViewer().getDocument().get();
			int lenght = context.getSourceViewer().getSelectedRange().y;
			int offset = context.getSourceViewer().getSelectedRange().x;
			return commentParser.hasComments(sourceCode, offset, offset + lenght);

		}
		;
		return false;

	}

	@Override
	public boolean canFix(Annotation arg0) {
		return false;
	}

	@Override
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext context) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		if (canAssist(context) && Translator.DO_NOT_CALL_AGAIN == false) {
			int lenght = context.getSourceViewer().getSelectedRange().y;
			int offset = context.getSourceViewer().getSelectedRange().x;

			String sourceCode = context.getSourceViewer().getDocument().get();

			Image image = QuickFixIcon.get();
			ICompletionProposal cPropSelectedComments;
			try {
				String translatedText = Translator.main(sourceCode.substring(offset, offset + lenght));
				if (translatedText.equals(""))
					return null;
				cPropSelectedComments = new QuickFIxProposal(translatedText, offset, lenght, 0, image,
						"Translate selection to English", null, translatedText, false);
				proposals.add(cPropSelectedComments);
				return proposals.toArray(new ICompletionProposal[1]);
			} catch (IOException e) {
				Translator.DO_NOT_CALL_AGAIN = true;
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	private boolean checkQuickFixAllowed() {
		return Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_TCTE_ALLOWED);
	}
}
