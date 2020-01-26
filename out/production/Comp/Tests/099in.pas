program summaElementov;
const
   n=20;
var
   a:array [1..n] of  integer;
   i,k,px,pn,max,min,s:integer;
begin
   readln(k);
   s:=0;
   pn:=1;
   px:=1;
   for i:=1 to k do
      readln(a[i]);
   max:=a[1];
   min:=a[1];
   for i:=2 to k do
      begin
         if a[i]>=max then
            begin
               max:=a[i];
               px:=i;
            end;
         if a[i]<=min then
            begin
               min:=a[i];
               pn:=i;
            end;
      end;
   if pn>px then
      for i:=px+1 to pn-1 do
         s:=s+a[i]
   else
      for i:=pn+1 to px-1 do
         s:=s+a[i];
   writeln(s);
end.