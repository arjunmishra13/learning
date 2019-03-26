import os

def grantDbPrivilegesToRole1(numberOfDatabases, outFile, role, action):
  f = open(outFile, 'w')
  for i in range(numberOfDatabases):
    f.write(("GRANT {} ON DATABASE db{} to ROLE {};\n").format(action, i, role))
  f.close()


if __name__ == "__main__":
  numberOfDatabases = 120
  directory = '/Users/amishra/Scripts/output/createDatabase/'
  if not os.path.exists(directory):
    os.makedirs(directory)

  outFile = directory + 'grantPrivileges.txt'
  role = 'role1'
  action = 'REFRESH'
  grantDbPrivilegesToRole1(numberOfDatabases, outFile, role, action)