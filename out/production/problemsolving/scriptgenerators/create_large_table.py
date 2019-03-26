import sys

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
def create_large_table(db_name, table_name, number_of_columns, number_of_partitions, outputfile):

  if number_of_columns < 2:
    raise ValueError('number_of_columns needs to be atleast 2')

  outputF = open(outputfile, 'w')

  create_database_command = "CREATE DATABASE IF NOT EXISTS " + db_name + SEMICOLON + END_CHARACTER;
  outputF.write(create_database_command)

  create_table_command1 = "CREATE TABLE IF NOT EXISTS " + db_name + DOT + table_name + SPACE + CURLY_OPEN_BRACKETS
  create_table_command2 = "PARTITIONED BY "
  location_str = "LOCATION '/user/hive/warehouse/"

  table_command = create_table_command1
  for col_val in range(1, number_of_columns):

    if col_val < number_of_columns - 1:
      table_command = table_command + COL + str(col_val) + SPACE + INT_TYPE + COMMA + SPACE
    else:
      table_command = table_command + COL + str(col_val) + SPACE + INT_TYPE + CURLY_CLOSE_BRACKETS + SPACE


  table_command = table_command + create_table_command2 + CURLY_OPEN_BRACKETS + COL + str(number_of_columns) + SPACE + INT_TYPE + CURLY_CLOSE_BRACKETS + SPACE
  table_command = table_command + location_str + db_name + DOT_DB + FORWARD_SLASH + SINGLE_QUOTES + SEMICOLON + END_CHARACTER

  outputF.write(table_command)

  create_partition_command1 = "ALTER TABLE "
  create_partition_command2 = "ADD PARTITION "

  base_partition_command = create_partition_command1 + db_name + DOT + table_name + SPACE + create_partition_command2 + CURLY_OPEN_BRACKETS
  for part_val in range(1, number_of_partitions + 1):
    partition_command = base_partition_command + COL + str(number_of_columns) + EQUALS + str(part_val) + CURLY_CLOSE_BRACKETS
    partition_command = partition_command + SPACE + location_str + db_name + DOT_DB + FORWARD_SLASH + table_name + FORWARD_SLASH + COL + str(number_of_columns) + EQUALS + str(part_val) + SINGLE_QUOTES + SEMICOLON + END_CHARACTER
    outputF.write(partition_command)

  outputF.close();

if __name__ == "__main__":
  db_name = "dbx"
  table_name = "tblz"
  number_of_columns = 5
  number_of_partitions = 10000
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/GenerateDataScripts/large_table.txt"
  create_large_table(db_name, table_name, number_of_columns, number_of_partitions, outputfile)