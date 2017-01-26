<?php

include 'Id3v2.php';

$i = new Id3v2;
$res = $i->read('ek-main-aur-ekk-tu01(www.songs.pk).mp3');

print_r($res);
