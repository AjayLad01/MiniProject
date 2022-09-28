import mysql.connector as m
  
# database which you want to backup
db = 'empinfo'
  
connection = m.connect(host='localhost', user='######',
                       password='######', database=db)
cursor = connection.cursor()
  
# Getting all the table names
cursor.execute('SHOW TABLES;')
table_names = []
for record in cursor.fetchall():
    table_names.append(record[0])
  
backup_dbname = db + '_backup'
try:
    cursor.execute(f'CREATE DATABASE {backup_dbname}')
except:
    pass
  
cursor.execute(f'USE {backup_dbname}')
  

