import os

def grantURIPrivilegesToRole1(numberOfDatabases, outFile, role, action):
  f = open(outFile, 'w')
  for i in range(numberOfDatabases):
    f.write(("GRANT {} ON URI '/user/hive/warehouse/location_{}' to ROLE {};\n").format(action, i, role))
  f.close()


if __name__ == "__main__":
  numberOfDatabases = 200
  directory = '/Users/amishra/Scripts/output/uri/'
  if not os.path.exists(directory):
    os.makedirs(directory)

  outFile = directory + 'grantPrivileges.txt'
  role = 'role1'
  action = 'ALL'
  grantURIPrivilegesToRole1(numberOfDatabases, outFile, role, action)