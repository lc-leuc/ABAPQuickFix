package com.abapblog.adt.quickfix.assist.comments;

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

public class RemoveAllComments implements IQuickAssistProcessor {
	AbapQuickFixRemoveCommentsCodeParser commentParser;

	@Override
	public boolean canAssist(IQuickAssistInvocationContext context) {
		if (checkQuickFixAllowed() == false) {
			return false;
		}
		commentParser = new AbapQuickFixRemoveCommentsCodeParser();
		String sourceCode = context.getSourceViewer().getDocument().get();
		return commentParser.hasComments(sourceCode, 0, sourceCode.length());
	}

	@Override
	public boolean canFix(Annotation arg0) {
		return false;
	}

	@Override
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext context) {
		List<ICompletionProposal> proposals = new ArrayList<>();
		if (canAssist(context)) {
			String sourceCode = context.getSourceViewer().getDocument().get();
			Image image = QuickFixIcon.get();
			ICompletionProposal cPropAllComments = new QuickFIxProposal(commentParser.parse(sourceCode), 0,
					sourceCode.length(), 0, image, "Remove all ABAP Comments", null,
					"Removes all ABAP Comments from the code. Please think twice before using it.", false);
			proposals.add(cPropAllComments);
			return proposals.toArray(new ICompletionProposal[1]);

		}
		;

		return null;

	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	private boolean checkQuickFixAllowed() {
		return !Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.HideRemoveAllComments);
	}

}
