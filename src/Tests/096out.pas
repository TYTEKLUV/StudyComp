1	1	KEY_WORD	program
1	9	IDENTIFIER	maximum
1	16	SEPARATOR	;
2	1	KEY_WORD	var
3	4	IDENTIFIER	a
3	5	SEPARATOR	,
3	6	IDENTIFIER	b
3	7	SEPARATOR	,
3	8	IDENTIFIER	c
3	9	SEPARATOR	,
3	10	IDENTIFIER	max
3	13	SEPARATOR	:
3	14	KEY_WORD	integer
3	21	SEPARATOR	;
4	1	KEY_WORD	begin
5	3	KEY_WORD	write
5	9	SEPARATOR	(
5	10	STRING	'a: '
5	15	SEPARATOR	)
5	16	SEPARATOR	;
6	3	KEY_WORD	readln
6	9	SEPARATOR	(
6	10	IDENTIFIER	a
6	11	SEPARATOR	)
6	12	SEPARATOR	;
7	3	KEY_WORD	write
7	9	SEPARATOR	(
7	10	STRING	'b: '
7	15	SEPARATOR	)
7	16	SEPARATOR	;
8	3	KEY_WORD	readln
8	9	SEPARATOR	(
8	10	IDENTIFIER	b
8	11	SEPARATOR	)
8	12	SEPARATOR	;
9	3	KEY_WORD	write
9	9	SEPARATOR	(
9	10	STRING	'c: '
9	15	SEPARATOR	)
9	16	SEPARATOR	;
10	3	KEY_WORD	readln
10	9	SEPARATOR	(
10	10	IDENTIFIER	c
10	11	SEPARATOR	)
10	12	SEPARATOR	;
11	3	KEY_WORD	if
11	6	SEPARATOR	(
11	7	IDENTIFIER	a
11	8	LOGIC_OPERATION	=
11	9	IDENTIFIER	b
11	10	SEPARATOR	)
11	12	KEY_WORD	and
11	16	SEPARATOR	(
11	17	IDENTIFIER	b
11	18	LOGIC_OPERATION	=
11	19	IDENTIFIER	c
11	20	SEPARATOR	)
11	22	KEY_WORD	then
12	6	KEY_WORD	writeln
12	14	SEPARATOR	(
12	15	STRING	'All equals '
12	28	SEPARATOR	,
12	30	IDENTIFIER	a
12	31	SEPARATOR	)
13	3	KEY_WORD	else
14	3	KEY_WORD	begin
15	6	KEY_WORD	if
15	9	SEPARATOR	(
15	10	IDENTIFIER	a
15	11	LOGIC_OPERATION	>
15	12	IDENTIFIER	c
15	13	SEPARATOR	)
15	15	KEY_WORD	and
15	19	SEPARATOR	(
15	20	IDENTIFIER	a
15	21	LOGIC_OPERATION	>
15	22	IDENTIFIER	b
15	23	SEPARATOR	)
15	25	KEY_WORD	then
16	9	IDENTIFIER	max
16	12	OPERATION	:=
16	14	IDENTIFIER	a
17	6	KEY_WORD	else
18	9	KEY_WORD	if
18	12	IDENTIFIER	b
18	13	LOGIC_OPERATION	>
18	14	IDENTIFIER	c
18	16	KEY_WORD	then
19	12	IDENTIFIER	max
19	15	OPERATION	:=
19	17	IDENTIFIER	b
20	9	KEY_WORD	else
21	12	IDENTIFIER	max
21	15	OPERATION	:=
21	17	IDENTIFIER	c
21	18	SEPARATOR	;
22	6	KEY_WORD	writeln
22	13	SEPARATOR	(
22	14	STRING	'Max: '
22	21	SEPARATOR	,
22	22	IDENTIFIER	max
22	25	SEPARATOR	)
22	26	SEPARATOR	;
23	3	KEY_WORD	end
23	6	SEPARATOR	;
24	1	KEY_WORD	end
24	4	SEPARATOR	.