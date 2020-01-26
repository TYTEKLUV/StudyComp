var
   a,x,z:integer;
   s1,s2,s3:integer;
   y:real;
procedure SuperSum (a,b:integer; var s:integer);
begin
   s:=a+b;
end;
begin
   readln(x,z,a);
   SuperSum(x,z,s1);
   SuperSum(3,a,s2);
   SuperSum(2,-4,s3);
   y:=s1/s2*s3;
   writeln(y);
end.