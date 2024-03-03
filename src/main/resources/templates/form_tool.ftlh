[#ftl]
[#assign x=""]
[@c.page title="NC Sheets"]
    <nav class="topnav">
        <div class="first-nav">
            <a class="topnav-list-link first" href="/">Přehled</a>
            <a class="topnav-list-link" href="#">Založit NC Sheet</a>
            <a class="topnav-list-link" href="/components">Komponenty</a>
        </div>
        <div class="second-nav">
            <a class="topnav-list-link" href="/components/tool">Zpět</a>
        </div>
    </nav>
    <div class="container center-box">

        <div class="form-box">
            <div class="form-head">
                <h1 class="heading-form">Nástroj formulář</h1>
            </div>
            <form action="/components/tool/form" method="post" class="form">

                <input type="hidden" name="id" />

                <div class="holder">
                    <label for="name">Název nástroje</label>
                    <input id="name" type="text" name="name" value="${form.name!x}" />
                </div>
                <div>
                    <label for="diameter">Průměr nástroje</label>
                    <input id="diameter" type="number" name="diameter" value="${form.diameter!x}"/>
                </div>
                <div>
                    <label for="length">Délka nástroje</label>
                    <input id="length" type="number" name="length" value="${form.length!x}"/>
                </div>
                <div class="size">
                    <label for="tooltype">Typ nástroje</label>
                    <select id="tooltype" name="tooltype.name">
                        [#if form.tooltype??]
                            <option value="${form.tooltype.name}">${form.tooltype.name}</option>
                        [#else]
                            <option value="Vyberte variantu">Vyberte variantu</option>
                        [/#if]
                        [#list form_tooltype]
                            [#items as item]
                                <option value="${item.name!x}">${item.name!x}</option>
                            [/#items]
                        [/#list]
                    </select>
                </div>
                <div class="btn-block">
                    <button class="btn btn-submit">Odeslat</button>
                </div>
            </form>
        </div>
    </div>
    </div>
[/@c.page]