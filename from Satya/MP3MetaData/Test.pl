use MP3::Tag;

$filename = "Harano Padak.mp3";

$mp3 = MP3::Tag->new($filename); # create object 

$mp3->get_tags(); # read tags

if (exists $mp3->{ID3v1}) { # print track information
print "Filename: $filename\n";
print "Artist: " . $mp3->{ID3v1}->artist . "\n";
print "Title: " . $mp3->{ID3v1}->title . "\n";
print "Album: " . $mp3->{ID3v1}->album . "\n";
print "Year: " . $mp3->{ID3v1}->year . "\n";
print "Genre: " . $mp3->{ID3v1}->genre . "\n";
}

$mp3->close(); # destroy object