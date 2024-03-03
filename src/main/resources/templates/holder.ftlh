[#ftl]
[@c.page title="NC Sheets"]
<nav class="topnav">
    <div class="first-nav">
        <a class="topnav-list-link" href="/">Přehled</a>
        <a class="topnav-list-link" href="#">Založit NC Sheet</a>
        <a class="topnav-list-link first" href="/components">Komponenty</a>
    </div>
    <div class="second-nav">
        <a class="topnav-list-link" href="/components">Zpět</a>
    </div>
</nav>

<div class="container">
    <div class="heading">
        <h1 class="heading-primary">Seznam držáků</h1>
        <a href="/components/holder/form" class="btn btn--full admin">Vytvořit nový</a>
    </div>
    [#list items.content]
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
                    <div class="input--2cols">
                        <a href="/components/holder/edit/${item.id}" class="btn btn--small btn--update">Upravit</a>
                        <form action="/components/holder/delete" method="post">
                            <input type="hidden" name="holderId" value="${item.id}" />
                            <button type="submit" class="btn btn--small btn--delete" onclick="if (!(confirm('Opravdu chcete položku vymazat?'))) return false">Smazat</button>
                        </form>
                    </div>
                </td>
            </tr>
        [/#items]
            <form action="/components/holder/filter" method="GET">
                <tr>
                    <td>
                        <input name="name" class="input-filter" type="search" value="${form.name!}" placeholder="Dle názvu">
                    </td>
                    <td>
                        <div class="input--2cols">
                            <input name="fromDiameter" class="input-filter" type="number" value="${form.fromDiameter!}" step="2" placeholder="od průměru">
                            <input name="toDiameter" class="input-filter" type="number" value="${form.toDiameter!}" step="2" placeholder="do průměru">
                        </div>
                    </td>
                    <td>
                        <div class="input--2cols">
                            <input name="fromLength" class="input-filter" type="number" value="${form.fromLength!}" step="2" placeholder="od délky">
                            <input name="toLength" class="input-filter" type="number" value="${form.toLength!}" step="2" placeholder="do délky">
                        </div>
                    </td>
                    <td>
                        <input name="size" class="input-filter" type="search" value="${form.size!}" placeholder="Filtrovat dle upnutí">
                    </td>
                    <td>
                        <button type="submit" class="btn btn--small btn--update" name="action" value="seach">Submit</button>
                    </td>
                </tr>
            </form>
        </tbody>
    </table>
    [#else]
        <div>Seznam je prázdný.</div>
    [/#list]
    <div class="container-button margin-top">
        <div>[@c.pager/]</div>
        <div>[@c.totalCount/]</div>
    </div>
</div>

[/@c.page]