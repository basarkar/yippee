<?php

include 'Id3.php';

$i = new Id3;
$res = $i->read('http://sound26.mp3pk.com/indian/emaet/ek-main-aur-ekk-tu01(www.songs.pk).mp3');

print_r($res);

