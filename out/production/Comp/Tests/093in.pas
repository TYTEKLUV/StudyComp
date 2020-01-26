var
   i,j,k:integer;
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