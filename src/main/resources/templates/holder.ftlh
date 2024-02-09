[#ftl]
[@c.page title="NC Sheets"]
<nav class="topnav">
    <div class="first-nav">
        <a class="topnav-list-link" href="mainpage.html">Přehled</a>
        <a class="topnav-list-link" href="#">Založit NC Sheet</a>
        <a class="topnav-list-link first" href="komponenty.html">Komponenty</a>
    </div>
    <div class="second-nav">
        <a class="topnav-list-link" href="komponenty.html">Zpět</a>
    </div>
</nav>

<div class="container">
    <div class="heading">
        <h1 class="heading-primary">Seznam držáků</h1>
        <a href="/administrace" class="btn btn--full admin">Vytvořit nový</a>
    </div>
    [#list holders.content]
    <table>
        <thead>
        <tr>
            <th class="heading-secondary">Název</th>
            <th class="heading-secondary">Průměr</th>
            <th class="heading-secondary">Délka</th>
            <th class="heading-secondary">Upínání</th>
            <th class="heading-secondary">Akce</th>
        </tr>
        </thead>
        <tbody>
        [#items as item]
            <tr>
                <td>${item.name}</td>
                <td>${item.diameter}</td>
                <td>${item.length}</td>
                <td>${item.holderSize.name}</td>
                <td>
                    <a href="/mainpage.html" class="btn btn--small btn--update"
                    >Upravit</a
                    >
                    <a href="/mainpage.html" class="btn btn--small btn--delete"
                    >Smazat</a
                    >
                </td>
            </tr>
        [/#items]
        </tbody>
    </table>
    [#else]
        <div>Seznam je prázdný.</div>
    [/#list]
</div>
[/@c.page]