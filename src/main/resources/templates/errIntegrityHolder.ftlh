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
                    <th class="heading-secondary">Název</th>
                </tr>
                </thead>
                <tbody>
                [#items as item]
                    <tr>
                        <td>
                            ${item.name}
                        </td>
                    </tr>
                [/#items]
                </tbody>
            </table>
        [/#list]
        <div class="container-button margin-top">
            <div>[@c.pager /]</div>
            <div>[@c.totalCount/]</div>
        </div>
    </div>
[/@c.page]