def printORRoles(roles):
	file = open("/Users/amishra/Scripts/output/orRoles.txt",'w')
	for i in range(roles):
		file.write("(`A0_SUB`.`ROLE_NAME` = 'r" + str(i) + "') OR\n")
	file.close()

if __name__ == "__main__":
	roles = 2000
	printORRoles(roles)
