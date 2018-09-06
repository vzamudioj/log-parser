SELECT * FROM logs.log

where date between '2017-01-01.00:00:00' and '2017-01-01.23:59:59'

GROUP BY ipAddress

HAVING count(ipAddress) >=500



;