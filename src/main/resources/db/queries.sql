--a
SELECT S.lid FROM Lion S WHERE SDO_FILTER( S.lcoord, SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1, 1003, 1),SDO_ORDINATE_ARRAY(150, 200, 400, 350)), 'querytype = WINDOW') = 'TRUE';

--b
SELECT S.lid FROM Lion S , Pond T1 WHERE SDO_WITHIN_DISTANCE( S.lcoord,T1.pcoord, 'distance = 150') = 'TRUE' AND  T1.pid = 'P1';

--d
SELECT T1.pid   FROM Lion S , Pond T1 WHERE SDO_NN( T1.pcoord,S.lcoord, 'sdo_num_res = 3') = 'TRUE' AND S.lid = 'L2';

--f
SELECT S.lid, B.pid From TABLE(SDO_JOIN('Lion', 'lcoord' , 'Pond', 'pcoord', 'mask=INSIDE')) c, Lion S, Pond B WHERE c.rowid1=S.rowid AND c.rowid2 = B.rowid;

--h
Select rid from Region where rid not in (SELECT distinct B.rid From TABLE(SDO_JOIN( 'Pond', 'pcoord','Region', 'rcoord', 'mask=INSIDE')) c, Pond S, Region B WHERE c.rowid1=S.rowid AND c.rowid2 = B.rowid) AND rid in (SELECT distinct B.rid From TABLE(SDO_JOIN('Lion', 'lcoord' , 'Region', 'rcoord', 'mask=INSIDE')) c, Lion S, Region B WHERE c.rowid1=S.rowid AND c.rowid2 = B.rowid);

--i
Select lid from Lion where lid not in (SELECT distinct S.lid From TABLE(SDO_JOIN('Lion', 'lcoord' , 'Ambulance', 'acoord', 'mask=INSIDE')) c, Lion S, Ambulance B WHERE c.rowid1=S.rowid AND c.rowid2 = B.rowid);
