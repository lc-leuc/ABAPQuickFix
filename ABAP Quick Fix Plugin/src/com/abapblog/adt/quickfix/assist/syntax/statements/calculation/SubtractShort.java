package com.abapblog.adt.quickfix.assist.syntax.statements.calculation;

import com.abapblog.adt.quickfix.assist.syntax.statements.StatementAssistRegex;
import com.sap.adt.tools.abapsource.ui.sources.IAbapSourceScannerServices.Token;

/*
 * Based on idea from https://software-heroes.com/en/new-abap-statements
 */
public class SubtractShort extends StatementAssistRegex {
	private static final String SUBTRACT_TOKEN = "SUBTRACT";
	private static final String MatchPattern = "SUBTRACT (\\w*) FROM (\\w*)";
	private static final String ReplacementPattern = "$2 = $2 - $1";

	@Override
	public String getAssistShortText() {
		return "Replace SUBTRACT y FROM x with x = x - y";
	}

	@Override
	public String getAssistLongText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAssist() {
		for (int i = 0; i < CodeReader.CurrentStatement.statementTokens.size(); i++) {
			Token currentToken = CodeReader.CurrentStatement.statementTokens.get(i);
			if (currentToken.name.toUpperCase().equals(SUBTRACT_TOKEN)
					&& CodeReader.scannerServices.isKeyword(CodeReader.sourcePage, currentToken.offset + 1, true)) {
				return true;
			}
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
	public String getMatchPattern() {
		return MatchPattern;
	}

	@Override
	public String getReplacePattern() {
		return ReplacementPattern;
	}

	@Override
	public String getChangedCode() {
		return CodeReader.CurrentStatement.replacePattern(getMatchPattern(), getReplacePattern());
	}

}
