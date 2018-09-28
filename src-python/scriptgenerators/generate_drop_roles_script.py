import sys

def generate_drop_roles(number_of_roles, group_id, outputfile):
  if number_of_roles == 0:
    sys.exit("Enter non-empty number_of_roles")

  outputF = open(outputfile, 'w')
  # insert_group = "INSERT INTO SENTRY_GROUP (GROUP_ID, GROUP_NAME) VALUES (" + str(group_id) + ", \"group_" + str(group_id) + "\");\n"
  # outputF.write(insert_group)

  insert_role_group = "DELETE FROM SENTRY_ROLE_GROUP_MAP WHERE ROLE_ID = "
  insert_role = "DELETE FROM SENTRY_ROLE WHERE ROLE_ID = "
  for i in range(100, number_of_roles):

    add_insert_role_group = insert_role_group + str(i) + ";\n"
    add_insert_role = insert_role + str(i) + ";\n"
    outputF.write(add_insert_role_group)
    outputF.write(add_insert_role)


  outputF.close();

if __name__ == "__main__":
  number_of_roles = 5000
  group_id = 1
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/GenerateDataScripts/delete_roles.txt"
  generate_drop_roles(number_of_roles, group_id, outputfile)