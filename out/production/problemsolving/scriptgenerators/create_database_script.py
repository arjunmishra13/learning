import os

def createDatabase(numberOfDatabases, outFile, outHDFSFile, role, outRoleGrantFile):
	f = open(outFile, 'w')
	fHDFS = open(outHDFSFile, 'w')
	if len(outRoleGrantFile) != 0:
		fRoleGrant = open(outRoleGrantFile, 'w')

	for i in range(numberOfDatabases):
		f.write(("CREATE DATABASE db{};\n").format(i))
		fHDFS.write(("hdfs dfs -mkdir /user/hive/warehouse/db{}.db\n").format(i))

		if len(role) != 0:
			fRoleGrant.write(("GRANT ALL ON DATABASE db{} to ROLE {};\n").format(i, role))

	f.close()
	fHDFS.close()
	fRoleGrant.close()


if __name__ == "__main__": 
	numberOfDatabases = 5000
	directory = '/Users/amishra/Scripts/output/createDatabase/'
	if not os.path.exists(directory):
		os.makedirs(directory)

	outFile = directory + 'createDatabaseOutput.txt'
	outHDFSFile = directory + 'hdfs_createDatabaseOutput.txt'
	outRoleGrantFile = directory + 'grantPrivileges.txt'

	role = "role1"
	createDatabase(numberOfDatabases, outFile, outHDFSFile, role, outRoleGrantFile)