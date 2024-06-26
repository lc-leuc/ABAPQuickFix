package com.abapblog.adt.quickfix.assist.syntax.statements.table.readTable;

import com.abapblog.adt.quickfix.assist.syntax.statements.IAssistRegex;
import com.abapblog.adt.quickfix.assist.syntax.statements.StatementAssist;

public class ReadTableIndexInto extends StatementAssist implements IAssistRegex {

	public ReadTableIndexInto() {
		super();
	}

	@Override
	public String getMatchPattern() {
		return IReadTablePatterns.readTableIndexInto;
	}

	@Override
	public String getReplacePattern() {
		return IReadTablePatterns.replacereadTableIndexInto;
	}

	@Override
	public String getAssistShortText() {
		return "Replace READ TABLE with Table Expression";
	}

	@Override
	public String getAssistLongText() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean canAssist() {
		if (CodeReader.CurrentStatement.matchPattern(getMatchPattern())
				&& !(new ReadTableIndexReferenceInto().canAssist())) {
			return true;
		}
		return false;
	}

	@Override
	public int getStartOfReplace() {
		return CodeReader.CurrentStatement.getBeginOfStatementReplacement();
	}

	@Override
	public int getReplaceLength() {
		return CodeReader.CurrentStatement.getStatementLength();
	}

	@Override
	public String getChangedCode() {
		return CodeReader.CurrentStatement.replacePattern(getMatchPattern(), getReplacePattern());
	}

}
