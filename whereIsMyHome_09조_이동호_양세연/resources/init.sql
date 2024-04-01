use ssafyhome;

select distinct * from dongcode;

select distinct left(dongCode, 2) sido, sidoName
from dongcode;


select distinct left(dongCode, 5) gugun, gugunName
from dongcode
where left(dongcode, 2) = 11
and gugunName is not null;


select distinct dongCode, dongName
from dongcode
where left(dongcode, 5) = 11110
and dongName is not null;



select dongCode, dongName
from dongcode
where left(dongcode, 5) = 11590
and dongName is not null;

select *
from houseinfo;


select *
from housedealhousedealsidoNamedongcodedongcode
where aptCode = 11110000000004;

select *
from houseinfo hi join housedeal hd
where hi.aptCode = hd.aptCode
and hi.aptCode =  11110000000004;

select count(*) from houseinfo;