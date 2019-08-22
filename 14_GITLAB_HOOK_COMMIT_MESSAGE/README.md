# Tips #14
update script to include in git server side hooks to match a commit pattern and reject the commit/push if not matchs, also to check if the email sent withim the commit is registered at gitlab. Put the listEmailsGitlab.sh at Crontab, for it to Update the list of emails.

create custom_hooks folder and put inside:
~/git-data/repositories/$GROUP/REPO.git/custom_hooks/
