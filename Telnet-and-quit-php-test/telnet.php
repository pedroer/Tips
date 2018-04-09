<?php
$output = shell_exec('echo exit | telnet desired_url desired_port');
echo "<pre>$output</pre>";
?>