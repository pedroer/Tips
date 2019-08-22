#!/bin/bash
while IFS=',' read -ra ADDR; do
      for i in "${ADDR[@]}"; do
        echo $i  
      done
done <<< `curl -H "Private-Token: YOUR_PRIVATE_GITLAB_USER_TOKEN" http://localhost:80/api/v4/users?per_page=1000`|grep @ >/home/git-scripts/listRegisteredEmails.txt
