import sys

DB = "db"
TBL = "tbl"
SEMICOLON = ";"
SPACE = " "
DOT = "."
FORWARD_SLASH = "/"
SINGLE_QUOTES = "'"
CURLY_CLOSE_BRACKETS = ")"
DOT_DB = ".db"
END_CHARACTER = "\n"
Z_EQUALS = "z="

def generate_data(databases, tables, partitions, outputfile, outputfilehdfs, skipHDFSPartitionScripts):


  outputF = open(outputfile, 'w+')
  outputFHDFS = open(outputfilehdfs, 'w+')


  create_database_command = "CREATE DATABASE "
  create_table_command1 = "CREATE TABLE "
  create_table_command2 = "(x INT) PARTITIONED BY (z INT) LOCATION '/user/hive/warehouse/"
  create_partition_command1 = "ALTER TABLE "
  create_partition_command2 = "ADD PARTITION (z="
  create_partition_command3 = "LOCATION '/user/hive/warehouse/"

  hdfs_mkdir_command = "hdfs dfs -mkdir /user/hive/warehouse/"

  for db in range(1, databases + 1):
    db_command = create_database_command + DB + str(db) + SEMICOLON
    db_command = db_command + END_CHARACTER
    hdfs_mkdir_command_db = hdfs_mkdir_command + DB + str(db) + DOT_DB
    print db_command, hdfs_mkdir_command_db
    outputF.write(db_command)
    outputFHDFS.write(hdfs_mkdir_command_db + END_CHARACTER)
    tables_per_database = tables/databases
    for tbl in range(1, tables_per_database + 1):
      tbl_command = create_table_command1 + DB + str(db) + DOT + TBL + str(tbl) + SPACE
      tbl_command = tbl_command + create_table_command2 + DB + str(db) + DOT_DB
      tbl_command = tbl_command + FORWARD_SLASH + TBL + str(tbl) + SINGLE_QUOTES + SEMICOLON
      tbl_command = tbl_command + END_CHARACTER
      hdfs_mkdir_command_tbl = hdfs_mkdir_command_db + FORWARD_SLASH + TBL + str(tbl)
      print tbl_command, hdfs_mkdir_command_tbl
      outputF.write(tbl_command)
      outputFHDFS.write(hdfs_mkdir_command_tbl + END_CHARACTER)

      partitions_per_tables = partitions/tables
      for parts in range(1, partitions_per_tables + 1):
        part_command = create_partition_command1 + DB + str(db) + DOT + TBL + str(tbl) + SPACE
        # part_command = part_command + create_partition_command2 + str(parts) + CURLY_CLOSE_BRACKETS + SPACE
        part_command = part_command + create_partition_command2 + str(parts) + CURLY_CLOSE_BRACKETS
        # part_command = part_command + create_partition_command3 + DB + str(db) + DOT_DB
        # part_command = part_command + FORWARD_SLASH + TBL + str(tbl) + SINGLE_QUOTES + SEMICOLON
        part_command = part_command + SEMICOLON + END_CHARACTER
        hdfs_mkdir_command_part = hdfs_mkdir_command_tbl + FORWARD_SLASH + Z_EQUALS + str(parts)
        print part_command,hdfs_mkdir_command_part
        outputF.write(part_command)
        if skipHDFSPartitionScripts == True:
          outputFHDFS.write(hdfs_mkdir_command_part + END_CHARACTER)


  outputF.close();
  outputFHDFS.close();

if __name__ == "__main__":
  databases = 10
  tables = 1000
  partitions = 700000
  outputfile = "/Users/amishra/Scripts/output/data/build_objects.txt"
  outputfilehdfs = "/Users/amishra/Scripts/output/data/hdfs_script_build_objects.txt"
  skipHDFSPartitionScripts = False
  generate_data(databases, tables, partitions, outputfile, outputfilehdfs, skipHDFSPartitionScripts)