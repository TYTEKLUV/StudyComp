1	1	KEY_WORD	var
2	4	IDENTIFIER	i
2	5	SEPARATOR	,
2	6	IDENTIFIER	j
2	7	SEPARATOR	,
2	8	IDENTIFIER	k
2	9	SEPARATOR	:
2	10	KEY_WORD	integer
2	17	SEPARATOR	;
3	1	KEY_WORD	procedure
3	11	IDENTIFIER	vektor
3	18	SEPARATOR	(
3	19	KEY_WORD	var
3	23	IDENTIFIER	a
3	24	SEPARATOR	:
3	25	IDENTIFIER	r
3	26	SEPARATOR	)
3	27	SEPARATOR	;
4	1	KEY_WORD	begin
5	4	IDENTIFIER	i
5	5	OPERATION	:=
5	7	INT	8
5	8	SEPARATOR	;
6	4	KEY_WORD	while
6	10	SEPARATOR	(
6	11	IDENTIFIER	a
6	12	SEPARATOR	[
6	13	IDENTIFIER	i
6	14	SEPARATOR	]
6	15	LOGIC_OPERATION	=
6	16	INT	8
6	17	SEPARATOR	)
6	19	KEY_WORD	do
7	7	KEY_WORD	begin
8	10	IDENTIFIER	a
8	11	SEPARATOR	[
8	12	IDENTIFIER	i
8	13	SEPARATOR	]
8	14	OPERATION	:=
8	16	INT	1
8	17	SEPARATOR	;
9	10	KEY_WORD	if
9	13	IDENTIFIER	i
9	14	LOGIC_OPERATION	>
9	15	INT	1
9	17	KEY_WORD	then
10	13	IDENTIFIER	i
10	14	OPERATION	:=
10	16	IDENTIFIER	i
10	17	OPERATION	-
10	18	INT	1
10	19	SEPARATOR	;
11	7	KEY_WORD	end
11	10	SEPARATOR	;
12	4	IDENTIFIER	a
12	5	SEPARATOR	[
12	6	IDENTIFIER	i
12	7	SEPARATOR	]
12	8	OPERATION	:=
12	10	IDENTIFIER	a
12	11	SEPARATOR	[
12	12	IDENTIFIER	i
12	13	SEPARATOR	]
12	14	OPERATION	+
12	15	INT	1
12	16	SEPARATOR	;
13	1	KEY_WORD	end
13	4	SEPARATOR	;