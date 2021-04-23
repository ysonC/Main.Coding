<html>
<head>
        <title>Blockbuster Database</title>
        <LINK REL='stylesheet' TYPE='text/css' HREF='dbicw.css'>
</head>
<body>
<h1>Actor Table</h1>

<?php
$addActor = $_GET['newActor'];

$db_host = 'mysql.cs.nott.ac.uk';
$db_user = 'efyhc5_COMP1004'; // change me
$db_pass = '000222isa'; // change me
$db_name = 'efyhc5_COMP1004'; // change me

$conn = new mysqli($db_host, $db_user, $db_pass, $db_name);
if ($conn->connect_errno)  die("failed to connect to database\n</body>\n</html>"); 

//$conn->query("INSERT into Actor (actID, actName) VALUES (0,'$addActor');");

if (! $conn->query("INSERT into Actor (actID, actName) VALUES (0,'$addActor');")) echo "Error: " . $sql . "<br>" . $conn->error . "<br>";
else    echo "Actor succesfully added.";

$sql = "SELECT actID, actName FROM Actor";
$stmt = $conn->prepare($sql);
$stmt->execute();
$stmt->bind_result($ID, $Name);

?>

<table width="750" border="1" cellpadding="1" cellspacing="1">
<tr> <th>ID</th> <th>Name</th> </tr>

<?php
while($stmt->fetch()){
  echo "<tr>";
  echo "<td>". htmlentities($ID) ."</td>";
  echo "<td>". htmlentities($Name) ."</td>";
  echo "</tr>";
}
?>
</table>
</body>
</html>

