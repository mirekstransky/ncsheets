[#ftl]
[@c.page title="NC Sheets-Integrity"]
    <nav class="topnav">
        <div class="first-nav">
            <a class="topnav-list-link" href="/">Přehled</a>
            <a class="topnav-list-link" href="#">Založit NC Sheet</a>
            <a class="topnav-list-link first" href="/components">Komponenty</a>
        </div>
        <div class="second-nav"></div>
    </nav>
    <div class="container">
        <div class="heading">
            <h1 class="heading-primary">Seznam integračních chyb</h1>
            <div></div>
        </div>
        [#list items.content]
            <table>
                <thead>
                <tr>
                    <th class="heading-secondary">Název sestavy</th>
                    <th class="heading-secondary">Akce</th>
                </tr>
                </thead>
                <tbody>
                [#items as item]
                    <tr>
                        <td>
                            ${item.name}
                        </td>
                        <td>
                            <a href="/component/holder/edit/${item.id}" class="btn btn--small btn--update">Upravit</a>
                        </td>
                    </tr>
                [/#items]
                </tbody>
            </table>
        [/#list]
        <div class="container-button margin-top">
            [@c.pager /]
        </div>
    </div>
    [@c.totalCount/]
[/@c.page]