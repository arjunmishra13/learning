from random import choice


COLUMN_BASE_TYPES = ['int', 'string']
DB_COUNT = 2
TABLE_COUNT = 1000000
COLUMN_COUNT = 10
ROLE_COUNT = 10
RIGHTS = ['SELECT', 'INSERT', 'ALL']


def add_database(db_base_name="db", count=DB_COUNT):
    for i in xrange(count):
        dbname = "{db_base_name}_{i:04d}".format(**locals())
        yield dbname, "CREATE DATABASE {};".format(dbname)


def add_table(database, table_base_name="tt", count=TABLE_COUNT, column_args={}):
    for i in xrange(count):
        tname = "{table_base_name}_{i:04d}".format(**locals())
        yield "{database}.{tname}".format(**locals()), "CREATE TABLE IF NOT EXISTS {database}.{tname} ({columns});".format(
            columns=", ".join(add_column(tname, **column_args)), **locals())


def add_column(table, column_base_name="c", column_base_types=COLUMN_BASE_TYPES, count=COLUMN_COUNT):
    for i in xrange(count):
        yield "{column_base_name}_{i:04d} {col_type}".format(col_type=choice(column_base_types), **locals())


def add_role(role_base_name='r', count=ROLE_COUNT):
    for i in xrange(count):
        rname = "{role_base_name}_{i:04d}".format(**locals())
        yield rname, "CREATE ROLE {};".format(rname)


def grant_rights_to_role(roles, tables):
    for table in tables:
        for role in roles:
            priv = choice(RIGHTS)
            yield "GRANT {priv} ON TABLE {table} TO ROLE {role};".format(**locals())


if __name__ == '__main__':

    tables = []
    roles = []
    file = open('/Users/amishra/Scripts/output/dbloader.txt', 'w')
#     for role, role_sql in add_role():
#         roles.append(role)
#         print(role_sql)
#         file.write(role_sql + "\n")
	
    for db_name, db_sql in add_database():
#         print(db_sql)
		file.write(db_sql + "\n")
		count = 1
		fileCount = 1
		for table, table_sql in add_table(db_name):
			tables.append(table)
#             print(table_sql)
			if count%100000 == 0:
				file.close()
				fileStr = "/Users/amishra/Scripts/output/dbloader" + str(fileCount) + ".txt"
				file = open(fileStr, 'w')
				fileCount = fileCount + 1
			file.write(table_sql + "\n")
			count = count + 1


#     for sql in grant_rights_to_role(roles, tables):
#         print(sql)
# 		file.write(sql + "\n")
		    
    file.close()
