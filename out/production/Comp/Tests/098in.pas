type
   r=array [1..8] of integer;
var
   i,j,k:integer;
   b:r;
   t,c:boolean;
procedure vektor (var a:r);
begin
   i:=8;
   while (a[i]=8) do
      begin
         a[i]:=1;
         if i>1 then
            i:=i-1;
      end;
   a[i]:=a[i]+1;
end;
begin
   for i:=1 to 8 do
      b[i]:=1;
   c:=true;
   while c=true do
      begin
         t:=true;
         for i:=1 to 8 do
            for j:=i+1 to 8 do
               if (b[i]=b[j]) or (abs(i-j)=abs(b[i]-b[j])) then
                  t:=false;
         if t=true then
            writeln(b);
         vektor(b);
         for i:=1 to 8 do
            k:=k+b[i];
         if k=64 then
            c:=false;
         k:=0;
      end;
end.