program z3;
const
   n=10;
var
   a:array[1..n] of integer;
   i,k,l,max,kmax,s,p:integer;
   sr:real;
begin
   write('Read number of elements: ');
   readln(k);
   s:=0;
   p:=0;
   l:=0;
   kmax:=0;
   for i:=1 to k do
      begin
         readln(a[i]);
         s:=s+a[i];
         if i=1 then
            max:=a[i]
         else
            if a[i]>max then
               max:=a[i];
         if a[i]>0 then
            p:=p+1
         else
            begin
               if p>l then
                  l:=p;
               p:=0;
            end;
         if i=k then
            if p>l then
               l:=p;
      end;
   for i:=1 to k do
      if a[i]=max then
         kmax:=kmax+1;
   sr:=s/k;
   writeln('Middle: ',sr);
   writeln('Max length: ',l);
   writeln('Number of max elements (Max: ',max,'): ',kmax);
end.