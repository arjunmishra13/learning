import sys

DBS = "db"
TBL = "tbl"
COL = "col"
ROLE = "role1"
SEMICOLON = ";"
SPACE = " "
DOT = "."
COMMA = ","
CURLY_OPEN_BRACKETS = "("
CURLY_CLOSE_BRACKETS = ")"
END_CHARACTER = "\n"
def grant_select_on_col(number_of_dbs, number_of_tbls, number_of_columns, outputfile):

  outputF = open(outputfile, 'w')
  for db in range(0, number_of_dbs):
    db_name = DBS + str(db)
    for tb in range(0,number_of_tbls):
      table_name = TBL + str(tb)
      grant_command = "GRANT SELECT " + CURLY_OPEN_BRACKETS

      for col_val in range(0, number_of_columns):

        if col_val < number_of_columns - 1:
          grant_command = grant_command + COL + str(col_val) + COMMA + SPACE
        else:
          grant_command = grant_command + COL + str(col_val) + CURLY_CLOSE_BRACKETS

      grant_command = grant_command + " ON TABLE " + db_name + DOT + table_name + " TO ROLE " + ROLE + SEMICOLON + END_CHARACTER

      outputF.write(grant_command)

  outputF.close()

if __name__ == "__main__":
  db = 10
  # per database
  tbls = 10
  cols = 25
  outputfile = "/Users/amishra/Scripts/output/grant_to_large_table.txt"
  grant_select_on_col(db, tbls, cols, outputfile)