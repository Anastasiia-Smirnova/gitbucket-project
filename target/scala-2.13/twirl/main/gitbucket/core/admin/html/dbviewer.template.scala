
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object dbviewer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Seq[gitbucket.core.controller.Table],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tables: Seq[gitbucket.core.controller.Table])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main("Database viewer")/*3.45*/ {_display_(Seq[Any](format.raw/*3.47*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.admin.html.menu("dbviewer")/*4.46*/ {_display_(Seq[Any](format.raw/*4.48*/("""
    """),format.raw/*5.5*/("""<div class="container">
      <div class="col-md-3">
        <div id="table-tree">
          <ul>
          """),_display_(/*9.12*/tables/*9.18*/.map/*9.22*/ { table =>_display_(Seq[Any](format.raw/*9.33*/("""
            """),format.raw/*10.13*/("""<li data-jstree='"""),format.raw/*10.30*/("""{"""),format.raw/*10.31*/(""""icon":""""),_display_(/*10.40*/context/*10.47*/.path),format.raw/*10.52*/("""/assets/common/images/table.gif""""),format.raw/*10.84*/("""}"""),format.raw/*10.85*/("""' data-table=""""),_display_(/*10.100*/table/*10.105*/.name),format.raw/*10.110*/("""">"""),_display_(/*10.113*/table/*10.118*/.name),format.raw/*10.123*/("""
              """),format.raw/*11.15*/("""<ul>
              """),_display_(/*12.16*/table/*12.21*/.columns.map/*12.33*/ { column =>_display_(Seq[Any](format.raw/*12.45*/("""
                """),format.raw/*13.17*/("""<li data-jstree='"""),format.raw/*13.34*/("""{"""),format.raw/*13.35*/(""""icon":""""),_display_(/*13.44*/context/*13.51*/.path),format.raw/*13.56*/("""/assets/common/images/column.gif""""),format.raw/*13.89*/("""}"""),format.raw/*13.90*/("""' data-table=""""),_display_(/*13.105*/table/*13.110*/.name),format.raw/*13.115*/("""" data-column=""""),_display_(/*13.131*/column/*13.137*/.name),format.raw/*13.142*/("""">
                  """),_display_(/*14.20*/column/*14.26*/.name),format.raw/*14.31*/(""" """),_display_(if(column.primaryKey)/*14.54*/{_display_(Seq[Any](format.raw/*14.55*/(""" """),format.raw/*14.56*/("""(PK) """)))} else {null} ),format.raw/*14.62*/("""
                """),format.raw/*15.17*/("""</li>
              """)))}),format.raw/*16.16*/("""
              """),format.raw/*17.15*/("""</ul>
            </li>
          """)))}),format.raw/*19.12*/("""
          """),format.raw/*20.11*/("""</ul>
        </div>
      </div>
      <div class="col-md-9">
        <div id="editor" style="width: 100%; height: 300px;"></div>
        <div class="block">
          <input type="button" value="Run query" id="run-query" class="btn btn-success">
          <input type="button" value="Clear" id="clear-query" class="btn btn-default">
          <label for="autorun">
            <input type="checkbox" id="autorun" name="autorun"/> Auto Run Query
          </label>
        </div>
        <div id="result"></div>
      </div>
    </div>
  """)))}),format.raw/*35.4*/("""
""")))}),format.raw/*36.2*/("""
"""),format.raw/*37.1*/("""<script src=""""),_display_(/*37.15*/helpers/*37.22*/.assets("/vendors/ace/ace.js")),format.raw/*37.52*/("""" type="text/javascript" charset="utf-8"></script>
<script src=""""),_display_(/*38.15*/helpers/*38.22*/.assets("/vendors/vakata-jstree-3.3.4/jstree.min.js")),format.raw/*38.75*/("""" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href=""""),_display_(/*39.31*/helpers/*39.38*/.assets("/vendors/vakata-jstree-3.3.4/themes/default/style.min.css")),format.raw/*39.106*/("""" />
<script>
function getPosition(editor, position)"""),format.raw/*41.39*/("""{"""),format.raw/*41.40*/("""
  """),format.raw/*42.3*/("""var session = editor.getSession();
  var result = 0;
  for(var i = 0; i < position.row; i++)"""),format.raw/*44.40*/("""{"""),format.raw/*44.41*/("""
    """),format.raw/*45.5*/("""result = result + session.getLine(i).length + 1;
  """),format.raw/*46.3*/("""}"""),format.raw/*46.4*/("""
  """),format.raw/*47.3*/("""return result + position.column;
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/("""

"""),format.raw/*50.1*/("""$(function()"""),format.raw/*50.13*/("""{"""),format.raw/*50.14*/("""
  """),format.raw/*51.3*/("""$('#editor').text($('#initial').val());
  var editor = ace.edit("editor");
  editor.setTheme("ace/theme/monokai");
  editor.getSession().setMode("ace/mode/sql");

  $('#table-tree').jstree();

  $('#table-tree').on('select_node.jstree', function(e, data)"""),format.raw/*58.62*/("""{"""),format.raw/*58.63*/("""
    """),format.raw/*59.5*/("""if(editor.getValue().trim() == '' || $('#autorun').is(':checked'))"""),format.raw/*59.71*/("""{"""),format.raw/*59.72*/("""
      """),format.raw/*60.7*/("""if(data.node.data['column'])"""),format.raw/*60.35*/("""{"""),format.raw/*60.36*/("""
        """),format.raw/*61.9*/("""editor.setValue('SELECT ' + data.node.data['column'] + ' FROM ' + data.node.data['table']);
      """),format.raw/*62.7*/("""}"""),format.raw/*62.8*/(""" """),format.raw/*62.9*/("""else if(data.node.data['table'])"""),format.raw/*62.41*/("""{"""),format.raw/*62.42*/("""
        """),format.raw/*63.9*/("""editor.setValue('SELECT * FROM ' + data.node.data['table']);
      """),format.raw/*64.7*/("""}"""),format.raw/*64.8*/("""
      """),format.raw/*65.7*/("""if($('#autorun').is(':checked'))"""),format.raw/*65.39*/("""{"""),format.raw/*65.40*/("""
        """),format.raw/*66.9*/("""$('#run-query').click();
      """),format.raw/*67.7*/("""}"""),format.raw/*67.8*/("""
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/(""" """),format.raw/*68.7*/("""else """),format.raw/*68.12*/("""{"""),format.raw/*68.13*/("""
      """),format.raw/*69.7*/("""var position = editor.getCursorPosition();
      var prefix = '';
      // Check a previous character
      if(position.column != 0)"""),format.raw/*72.31*/("""{"""),format.raw/*72.32*/("""
        """),format.raw/*73.9*/("""var range = new ace.Range(position.row, position.column - 1, position.row, position.column);
        var c = editor.getSession().getTextRange(range);
        if(c != '' && c != ' ' && c != '.' && c != ',' && c != '\t' && c != '\r' && c != '\n')"""),format.raw/*75.95*/("""{"""),format.raw/*75.96*/("""
          """),format.raw/*76.11*/("""prefix = ', ';
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/("""
      """),format.raw/*78.7*/("""}"""),format.raw/*78.8*/("""
      """),format.raw/*79.7*/("""if(data.node.data['column'])"""),format.raw/*79.35*/("""{"""),format.raw/*79.36*/("""
        """),format.raw/*80.9*/("""editor.getSession().insert(position, prefix + data.node.data['column']);
      """),format.raw/*81.7*/("""}"""),format.raw/*81.8*/(""" """),format.raw/*81.9*/("""else if(data.node.data['table'])"""),format.raw/*81.41*/("""{"""),format.raw/*81.42*/("""
        """),format.raw/*82.9*/("""editor.getSession().insert(position, prefix + data.node.data['table']);
      """),format.raw/*83.7*/("""}"""),format.raw/*83.8*/("""
    """),format.raw/*84.5*/("""}"""),format.raw/*84.6*/("""
    """),format.raw/*85.5*/("""editor.focus();
  """),format.raw/*86.3*/("""}"""),format.raw/*86.4*/(""");

  $('#clear-query').click(function()"""),format.raw/*88.37*/("""{"""),format.raw/*88.38*/("""
    """),format.raw/*89.5*/("""editor.setValue('');
  """),format.raw/*90.3*/("""}"""),format.raw/*90.4*/(""");

  $('#run-query').click(function()"""),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""
    """),format.raw/*93.5*/("""var selectedText = editor.getSession().doc.getTextRange(editor.selection.getRange()).trim();

    $.post('"""),_display_(/*95.14*/context/*95.21*/.path),format.raw/*95.26*/("""/admin/dbviewer/_query', """),format.raw/*95.51*/("""{"""),format.raw/*95.52*/(""" """),format.raw/*95.53*/("""query: selectedText == '' ? editor.getValue() : selectedText """),format.raw/*95.114*/("""}"""),format.raw/*95.115*/(""",
      function(data)"""),format.raw/*96.21*/("""{"""),format.raw/*96.22*/("""
        """),format.raw/*97.9*/("""if(data.type == "query")"""),format.raw/*97.33*/("""{"""),format.raw/*97.34*/("""
          """),format.raw/*98.11*/("""var table = $('<table class="table table-bordered table-hover table-scroll">');

          var header = $('<tr>');
          $.each(data.columns, function(i, column)"""),format.raw/*101.51*/("""{"""),format.raw/*101.52*/("""
            """),format.raw/*102.13*/("""header.append($('<th>').text(column));
          """),format.raw/*103.11*/("""}"""),format.raw/*103.12*/(""");
          table.append($('<thead>').append(header));

          var body = $('<tbody>');
          $.each(data.rows, function(i, rs)"""),format.raw/*107.44*/("""{"""),format.raw/*107.45*/("""
            """),format.raw/*108.13*/("""var row = $('<tr>');
            $.each(data.columns, function(i, column)"""),format.raw/*109.53*/("""{"""),format.raw/*109.54*/("""
              """),format.raw/*110.15*/("""row.append($('<td>').text(rs[column]));
            """),format.raw/*111.13*/("""}"""),format.raw/*111.14*/(""");
            body.append(row);
          """),format.raw/*113.11*/("""}"""),format.raw/*113.12*/(""");

          table.append(body);
          $('#result').empty().append(table);

        """),format.raw/*118.9*/("""}"""),format.raw/*118.10*/(""" """),format.raw/*118.11*/("""else if(data.type == "update")"""),format.raw/*118.41*/("""{"""),format.raw/*118.42*/("""
          """),format.raw/*119.11*/("""$('#result').empty().append($('<span>').text('Updated ' + data.rows + ' rows.'));

        """),format.raw/*121.9*/("""}"""),format.raw/*121.10*/(""" """),format.raw/*121.11*/("""else if(data.type == "error")"""),format.raw/*121.40*/("""{"""),format.raw/*121.41*/("""
          """),format.raw/*122.11*/("""$('#result').empty().append($('<span class="error">').text(data.message));
        """),format.raw/*123.9*/("""}"""),format.raw/*123.10*/("""
      """),format.raw/*124.7*/("""}"""),format.raw/*124.8*/("""
    """),format.raw/*125.5*/(""");
  """),format.raw/*126.3*/("""}"""),format.raw/*126.4*/(""");
"""),format.raw/*127.1*/("""}"""),format.raw/*127.2*/(""");
</script>
"""))
      }
    }
  }

  def render(tables:Seq[gitbucket.core.controller.Table],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(tables)(context)

  def f:((Seq[gitbucket.core.controller.Table]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (tables) => (context) => apply(tables)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/dbviewer.scala.html
                  HASH: bf77097b725d97a9d970ab9f79f219d97ccab176
                  MATRIX: 648->1|820->102|883->138|900->147|942->181|981->183|1010->187|1027->196|1068->229|1107->231|1138->236|1273->345|1287->351|1299->355|1347->366|1388->379|1433->396|1462->397|1498->406|1514->413|1540->418|1600->450|1629->451|1672->466|1687->471|1714->476|1745->479|1760->484|1787->489|1830->504|1877->524|1891->529|1912->541|1962->553|2007->570|2052->587|2081->588|2117->597|2133->604|2159->609|2220->642|2249->643|2292->658|2307->663|2334->668|2378->684|2394->690|2421->695|2470->717|2485->723|2511->728|2561->751|2600->752|2629->753|2679->759|2724->776|2776->797|2819->812|2885->847|2924->858|3494->1398|3526->1400|3554->1401|3595->1415|3611->1422|3662->1452|3754->1517|3770->1524|3844->1577|3952->1658|3968->1665|4058->1733|4138->1785|4167->1786|4197->1789|4317->1881|4346->1882|4378->1887|4456->1938|4484->1939|4514->1942|4574->1975|4602->1976|4631->1978|4671->1990|4700->1991|4730->1994|5012->2248|5041->2249|5073->2254|5167->2320|5196->2321|5230->2328|5286->2356|5315->2357|5351->2366|5476->2464|5504->2465|5532->2466|5592->2498|5621->2499|5657->2508|5751->2575|5779->2576|5813->2583|5873->2615|5902->2616|5938->2625|5996->2656|6024->2657|6056->2662|6084->2663|6112->2664|6145->2669|6174->2670|6208->2677|6368->2809|6397->2810|6433->2819|6705->3063|6734->3064|6773->3075|6823->3098|6852->3099|6886->3106|6914->3107|6948->3114|7004->3142|7033->3143|7069->3152|7175->3231|7203->3232|7231->3233|7291->3265|7320->3266|7356->3275|7461->3353|7489->3354|7521->3359|7549->3360|7581->3365|7626->3383|7654->3384|7722->3424|7751->3425|7783->3430|7833->3453|7861->3454|7927->3492|7956->3493|7988->3498|8122->3605|8138->3612|8164->3617|8217->3642|8246->3643|8275->3644|8365->3705|8395->3706|8445->3728|8474->3729|8510->3738|8562->3762|8591->3763|8630->3774|8824->3939|8854->3940|8896->3953|8974->4002|9004->4003|9168->4138|9198->4139|9240->4152|9342->4225|9372->4226|9416->4241|9497->4293|9527->4294|9599->4337|9629->4338|9746->4427|9776->4428|9806->4429|9865->4459|9895->4460|9935->4471|10054->4562|10084->4563|10114->4564|10172->4593|10202->4594|10242->4605|10353->4688|10383->4689|10418->4696|10447->4697|10480->4702|10513->4707|10542->4708|10573->4711|10602->4712
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|26->9|26->9|26->9|26->9|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|28->11|29->12|29->12|29->12|29->12|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|33->16|34->17|36->19|37->20|52->35|53->36|54->37|54->37|54->37|54->37|55->38|55->38|55->38|56->39|56->39|56->39|58->41|58->41|59->42|61->44|61->44|62->45|63->46|63->46|64->47|65->48|65->48|67->50|67->50|67->50|68->51|75->58|75->58|76->59|76->59|76->59|77->60|77->60|77->60|78->61|79->62|79->62|79->62|79->62|79->62|80->63|81->64|81->64|82->65|82->65|82->65|83->66|84->67|84->67|85->68|85->68|85->68|85->68|85->68|86->69|89->72|89->72|90->73|92->75|92->75|93->76|94->77|94->77|95->78|95->78|96->79|96->79|96->79|97->80|98->81|98->81|98->81|98->81|98->81|99->82|100->83|100->83|101->84|101->84|102->85|103->86|103->86|105->88|105->88|106->89|107->90|107->90|109->92|109->92|110->93|112->95|112->95|112->95|112->95|112->95|112->95|112->95|112->95|113->96|113->96|114->97|114->97|114->97|115->98|118->101|118->101|119->102|120->103|120->103|124->107|124->107|125->108|126->109|126->109|127->110|128->111|128->111|130->113|130->113|135->118|135->118|135->118|135->118|135->118|136->119|138->121|138->121|138->121|138->121|138->121|139->122|140->123|140->123|141->124|141->124|142->125|143->126|143->126|144->127|144->127
                  -- GENERATED --
              */
          