package com.abapblog.adt.quickfix.assist.syntax.statements.ReadTable;

public interface IReadTablePatterns {

	public static final String readTableWithKeyInto = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)(into)\\s+(.*)";
	public static final String replaceReadTableWithKeyInto = "$8 = $3[ $6 ]";
	public static final String readTableRefereceWithKey = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(reference)\\s+(into)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)";
	public static final String replaceReadTableRefereceWithKey = "$6 = REF #( $3[ $9 ] )";
	public static final String readTableAssigningIndex = "(read).*(table)\\s+(\\S*)\\s+.*(assigning)\\s+(\\S*)\\s+.*(index)\\s+(\\S*)";
	public static final String replaceReadTableAssigningIndex = "ASSIGN $3[ $7 ] TO $5";
	public static final String readTableAssigningWithKey = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(assigning)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)";
	public static final String replaceReadTableAssigningWithKey = "ASSIGN $3[ $8 ] TO $5";
	public static final String readTableIndexAssigning = "(read).*(table)\\s+(\\S*)\\s+.*(index)\\s+(\\S*)\\s+.*(assigning)\\s+(\\S*)";
	public static final String replacereadTableIndexAssigning = "ASSIGN $3[ $5 ] TO $7";
	public static final String readTableIndexInto = "(read).*(table)\\s+(\\S*)\\s+.*(index)\\s+(\\S*)\\s+.*(into)\\s+(\\S*)";
	public static final String replacereadTableIndexInto = "$7 = $3[ $5 ]";
	public static final String readTableIndexReferece = "(read).*(table)\\s+(\\S*)\\s+.*(index)\\s+(\\S*)\\s+.*(reference)\\s+(into)\\s+(\\S*)";
	public static final String replacereadTableIndexReferece = "$8 = REF #( $3[ $5 ] )";
	public static final String readTableIntoIndex = "(read).*(table)\\s+(\\S*)\\s+.*(into)\\s+(\\S*)\\s+.*(index)\\s+(\\S*)";
	public static final String replaceReadTableIntoIndex = "$5 = $3[ $7 ]";
	public static final String readTableIntoWithKey = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(into)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)";
	public static final String replaceReadTableIntoWithKey = "$5 = $3[ $8 ]";
	public static final String readTableRefereceIndex = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(reference)\\s+(into)\\s+(\\S*)\\s+.*(index)\\s+(.*)";
	public static final String replaceReadTableRefereceIndex = "$6 = REF #( $3[ $8 ] )";
	public static final String readTableWithKeyAssigning = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)(assigning)\\s+(.*)";
	public static final String replaceReadTableWithKeyAssigning = "ASSIGN $3[ $6 ] TO $8";
	public static final String readTableWithKeyReferece = "(?s)(read).*(table)\\s+(\\S*)\\s+.*(with)\\s+(key)\\s+(.*)(reference)\\s+(into)\\s+(.*)";
	public static final String replaceReadTableWithKeyReferece = "$9 = REF #( $3[ $6 ] )";

}
