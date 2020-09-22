<html>
    <head>
        <title>CALCULATOR</title>
    </head>
     <body>
        <% 
            Cookie c[] = request.getCookies();
        %>
        
        <p><%out.println("Valor X: " + request.getParameter("valorX"));%></p><br>
        <p><%out.println("Valor Y: " + request.getParameter("valorY"));%></p><br>
        <p><%out.println("Operação: " + request.getParameter("operacao"));%></p><br>
        <p><%out.println("Resultado: " + request.getAttribute("result"));%></p><br>
        
        <h1>Total de acessos: 
            <%
                
                if(c != null)
                {
                    for(int i=0; i <= c.length - 1; i++)
                    {
                        if(c[i].getName().equals("totalAccess"))
                        {
                            out.println(c[i].getValue());
                        }
                    }
                }
            %>
        </h1>
    </body>
</html>