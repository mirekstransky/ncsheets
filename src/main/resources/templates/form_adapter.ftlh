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
            <a class="topnav-list-link" href="/components/adapter">Zpět</a>
        </div>
    </nav>
    <div class="container center-box">

        <div class="form-box">
            <div class="form-head">
                <h1 class="heading-form">Adaptér formulář</h1>
            </div>
            <form action="/components/adapter/form" method="post" class="form">
                <input type="hidden" name="id" />
                <div>
                    <label for="name">Název adaptéru</label>
                    <input id="name" type="text" name="name" value="${form.name!x}" />
                </div>
                <div>
                    <label for="diameter">Průměr adaptéru</label>
                    <input id="diameter" type="number" name="diameter" placeholder="Průměr držáku" value="${form.diameter!x}"/>
                </div>
                <div>
                    <label for="length">Délka adaptéru</label>
                    <input id="length" type="number" name="length" placeholder="Délka držáku" value="${form.length!x}"/>
                </div>
                <div class="btn-block">
                    <button class="btn btn-submit">Odeslat</button>
                </div>
            </form>
        </div>
    </div>
[/@c.page]