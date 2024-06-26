package com.abapblog.adt.quickfix.assist.syntax.statements.move;

import com.abapblog.adt.quickfix.assist.syntax.statements.IAssistRegex;
import com.abapblog.adt.quickfix.assist.syntax.statements.StatementAssist;

public class MoveExact extends StatementAssist implements IAssistRegex {

	private static final String moveExactPattern = "(?s)(move)\\s+(exact)\\s+(.*)\\s+(to)\\s+(.*)";
	private static final String replacemoveExactPattern = "$5 = EXACT #( $3 )";

	public MoveExact() {
		super();
	}

	@Override
	public String getMatchPattern() {
		return moveExactPattern;
	}

	@Override
	public String getReplacePattern() {
		return replacemoveExactPattern;
	}

	@Override
	public String getChangedCode() {
		return CodeReader.CurrentStatement.replacePattern(getMatchPattern(), getReplacePattern());
	}

	@Override
	public String getAssistShortText() {
		// TODO Auto-generated method stub
		return "Replace MOVE EXACT with EXACT #( )";
	}

	@Override
	public String getAssistLongText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAssist() {
		if (CodeReader.CurrentStatement.matchPattern(getMatchPattern())) {
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

}
