# Tips #15
update script to include in git server side hooks to match a commit pattern and reject the commit/push if a file that you want to lock was modified
in this case I used as a sample that gitlab-ci.yml file

create custom_hooks folder and put inside:
~/git-data/repositories/$GROUP/REPO.git/custom_hooks/
