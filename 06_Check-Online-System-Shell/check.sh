#! /bin/bash
while true
do
if curl -L -s --head  --request GET http://SYSTEM_URL/ |egrep "200 OK" > /dev/null; then   
	echo "OK " 
else
   smtp-source -F emailoff.txt -f test_from@teste.com  -t teste_to@teste.com  email_host:25
fi
sleep 300
done
