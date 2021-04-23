<html>
<head>
        <title>Blockbuster Database</title>
        <LINK REL='stylesheet' TYPE='text/css' HREF='dbicw.css'>
</head>
<body>
<h1>All Movie</h1>

<?php
$db_host = 'mysql.cs.nott.ac.uk';
$db_user = 'efyhc5_COMP1004'; // change me
$db_pass = '000222isa'; // change me
$db_name = 'efyhc5_COMP1004'; // change me

$conn = new mysqli($db_host, $db_user, $db_pass, $db_name);
if ($conn->connect_errno)  die("failed to connect to database\n</body>\n</html>"); 

$sql="SELECT * FROM Actor";
$stmt = $conn->prepare($sql);
$stmt->execute();
$stmt->bind_result($actID, $actName );
?>

<table width="750" border="1" cellpadding="1" cellspacing="1">
<tr> <th>Actor ID</th> <th>Name</th>  </tr>

<?php
while($stmt->fetch()){
  echo "<tr>";
  echo "<td>". htmlentities($actID) ."</td>";
  echo "<td>". htmlentities($actName) ."</td>";
  echo "</tr>";
}
?>
</table>
</body>
</html>

