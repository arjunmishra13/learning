import sys

DBS = "db"
TBL = "tbl"
COL = "col"
SEMICOLON = ";"
EQUALS = "="
SPACE = " "
DOT = "."
COMMA = ","
FORWARD_SLASH = "/"
SINGLE_QUOTES = "'"
CURLY_OPEN_BRACKETS = "("
CURLY_CLOSE_BRACKETS = ")"
DOT_DB = ".db"
END_CHARACTER = "\n"
INT_TYPE = "INT"
def create_large_table(number_of_dbs, number_of_tbls, number_of_columns, outputfile):

  outputF = open(outputfile, 'w')
  for db in range(0, number_of_dbs):
    db_name = DBS + str(db)
    create_database_command = "CREATE DATABASE IF NOT EXISTS " + db_name + SEMICOLON + END_CHARACTER
    outputF.write(create_database_command)

    for tb in range(0,number_of_tbls):
      table_name = TBL + str(tb)
      create_table_command = "CREATE TABLE IF NOT EXISTS " + db_name + DOT + table_name + SPACE + CURLY_OPEN_BRACKETS

      table_command = create_table_command
      for col_val in range(0, number_of_columns):

        if col_val < number_of_columns - 1:
          table_command = table_command + COL + str(col_val) + SPACE + INT_TYPE + COMMA + SPACE
        else:
          table_command = table_command + COL + str(col_val) + SPACE + INT_TYPE + CURLY_CLOSE_BRACKETS + SEMICOLON + END_CHARACTER

      outputF.write(table_command)

  outputF.close()

if __name__ == "__main__":
  db = 10
  # per database
  tbls = 10
  cols = 25
  outputfile = "/Users/amishra/Scripts/output/large_table.txt"
  create_large_table(db, tbls, cols, outputfile)