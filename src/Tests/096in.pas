program maximum;
var
   a,b,c,max:integer;
begin
  write ('a: ');
  readln(a);
  write ('b: ');
  readln(b);
  write ('c: ');
  readln(c);
  if (a=b) and (b=c) then
     writeln ('All equals ', a)
  else
  begin
     if (a>c) and (a>b) then
        max:=a
     else
        if b>c then
           max:=b
        else
           max:=c;
     writeln('Max: ',max);
  end;
end.