import sys

DB = "db"
TBL = "tbl"
SEMICOLON = ";"
SPACE = " "
DOT = "."
FORWARD_SLASH = "/"
SINGLE_QUOtES = "'"
CURLY_CLOSE_BRACKETS = ")"
DOT_DB = ".db"
END_CHARACTER = "\n"
def generate_data(databases, tables, partitions, outputfile):


  outputF = open(outputfile, 'w')


  create_database_command = "CREATE DATABASE "
  create_table_command1 = "CREATE TABLE "
  create_table_command2 = "(x INT) PARTITIONED BY (z INT) LOCATION '/user/hive/warehouse/"
  create_partition_command1 = "ALTER TABLE "
  create_partition_command2 = "ADD PARTITION (z="
  create_partition_command3 = "LOCATION '/user/hive/warehouse/"

  for db in range(1, databases + 1):
    db_command = create_database_command + DB + str(db) + SEMICOLON
    db_command = db_command + END_CHARACTER
    print db_command
    outputF.write(db_command)
    tables_per_database = tables/databases
    for tbl in range(1, tables_per_database + 1):
      tbl_command = create_table_command1 + DB + str(db) + DOT + TBL + str(tbl) + SPACE
      tbl_command = tbl_command + create_table_command2 + DB + str(db) + DOT_DB
      tbl_command = tbl_command + FORWARD_SLASH + TBL + str(tbl) + SINGLE_QUOtES + SEMICOLON
      print tbl_command
      tbl_command = tbl_command + END_CHARACTER
      outputF.write(tbl_command)

      partitions_per_tables = partitions/tables
      for parts in range(1, partitions_per_tables + 1):
        part_command = create_partition_command1 + DB + str(db) + DOT + TBL + str(tbl) + SPACE
        part_command = part_command + create_partition_command2 + str(parts) + CURLY_CLOSE_BRACKETS + SPACE
        part_command = part_command + create_partition_command3 + DB + str(db) + DOT_DB
        part_command = part_command + str(tbl) + FORWARD_SLASH + TBL + str(tbl) + SINGLE_QUOtES + SEMICOLON
        print part_command
        part_command = part_command + END_CHARACTER
        outputF.write(part_command)


  outputF.close();

if __name__ == "__main__":
  databases = 100
  tables = 1000
  partitions = 10000
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/GenerateDataScripts/build_objects.txt"
  generate_data(databases, tables, partitions, outputfile)