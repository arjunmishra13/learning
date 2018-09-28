import sys

def generate_roles_for_one_group(number_of_roles, group_id, outputfile):
  if number_of_roles == 0:
    sys.exit("Enter non-empty number_of_roles")

  outputF = open(outputfile, 'w')
  insert_group = "INSERT INTO SENTRY_GROUP (GROUP_ID, GROUP_NAME) VALUES (" + str(group_id) + ", \"group_" + str(group_id) + "\");\n"
  outputF.write(insert_group)

  insert_role = "INSERT INTO SENTRY_ROLE (ROLE_ID, ROLE_NAME) VALUES ("
  insert_role_group = "INSERT INTO SENTRY_ROLE_GROUP_MAP (ROLE_ID, GROUP_ID, GRANTOR_PRINCIPAL) VALUES ("
  for i in range(3000, number_of_roles):

    add_insert_role = insert_role + str(i) + ", \"role_" + str(i) + "\");\n"
    add_insert_role_group = insert_role_group + str(i) + "," + str(group_id) + ",\"test\");\n"
    outputF.write(add_insert_role)
    outputF.write(add_insert_role_group)


  outputF.close();

if __name__ == "__main__":
  number_of_roles = 4000
  group_id = 1
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/GenerateDataScripts/create_roles.txt"
  generate_roles_for_one_group(number_of_roles, group_id, outputfile)