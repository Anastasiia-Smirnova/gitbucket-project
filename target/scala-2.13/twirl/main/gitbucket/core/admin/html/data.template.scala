
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object data extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Seq[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tableNames: Seq[String])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.80*/("""
"""),_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Data export / import")/*2.50*/{_display_(Seq[Any](format.raw/*2.51*/("""
  """),_display_(/*3.4*/gitbucket/*3.13*/.core.admin.html.menu("data")/*3.42*/ {_display_(Seq[Any](format.raw/*3.44*/("""
    """),format.raw/*4.5*/("""<div class="panel panel-default">
      <div class="panel-heading strong">Export</div>
      <div class="panel-body">
        <form class="form form-horizontal" action=""""),_display_(/*7.53*/context/*7.60*/.path),format.raw/*7.65*/("""/admin/export" method="POST">
          """),_display_(/*8.12*/tableNames/*8.22*/.map/*8.26*/ { tableName =>_display_(Seq[Any](format.raw/*8.41*/("""
            """),format.raw/*9.13*/("""<div class="checkbox">
              <label>
                <input type="checkbox" name="tableNames" id=""""),_display_(/*11.63*/tableName),format.raw/*11.72*/("""" value=""""),_display_(/*11.82*/tableName),format.raw/*11.91*/("""" checked/> """),_display_(/*11.104*/tableName),format.raw/*11.113*/("""
              """),format.raw/*12.15*/("""</label>
            </div>
          """)))}),format.raw/*14.12*/("""
          """),format.raw/*15.11*/("""<input type="submit" class="btn btn-success pull-right" value="Export">
        </form>
      </div>
    </div>

    <div class="panel panel-default">
      <div class="panel-heading strong">Import</div>
      <div class="panel-body">
        <form class="form form-horizontal" action=""""),_display_(/*23.53*/context/*23.60*/.path),format.raw/*23.65*/("""/upload/import" method="POST" enctype="multipart/form-data" id="import-form">
          <input type="file" name="file" id="file" aria-label="Upload file">
          <input type="submit" class="btn btn-success pull-right" value="Import" id="import">
        </form>
      </div>
    </div>
  """)))}),format.raw/*29.4*/("""
""")))}),format.raw/*30.2*/("""
"""),format.raw/*31.1*/("""<script>
$(function()"""),format.raw/*32.13*/("""{"""),format.raw/*32.14*/("""
  """),format.raw/*33.3*/("""$('#import-form').submit(function()"""),format.raw/*33.38*/("""{"""),format.raw/*33.39*/("""
    """),format.raw/*34.5*/("""if($('#file').val() == '')"""),format.raw/*34.31*/("""{"""),format.raw/*34.32*/("""
      """),format.raw/*35.7*/("""alert('Choose an import SQL file.');
      return false;
    """),format.raw/*37.5*/("""}"""),format.raw/*37.6*/(""" """),format.raw/*37.7*/("""else if(!$('#file').val().endsWith(".sql"))"""),format.raw/*37.50*/("""{"""),format.raw/*37.51*/("""
      """),format.raw/*38.7*/("""alert('Import is available for only the SQL file.');
      return false;
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/("""
    """),format.raw/*41.5*/("""return confirm('All existing data is deleted before importing.\nAre you sure?');
  """),format.raw/*42.3*/("""}"""),format.raw/*42.4*/(""")
"""),format.raw/*43.1*/("""}"""),format.raw/*43.2*/(""")
</script>
"""))
      }
    }
  }

  def render(tableNames:Seq[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(tableNames)(context)

  def f:((Seq[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (tableNames) => (context) => apply(tableNames)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/data.scala.html
                  HASH: 9b83d3c89610c62485e7ce37534db468286d23f9
                  MATRIX: 619->1|792->79|820->82|837->91|884->130|922->131|952->136|969->145|1006->174|1045->176|1077->182|1276->355|1291->362|1316->367|1384->409|1402->419|1414->423|1466->438|1507->452|1643->561|1673->570|1710->580|1740->589|1781->602|1812->611|1856->627|1928->668|1968->680|2290->975|2306->982|2332->987|2660->1285|2693->1288|2722->1290|2772->1312|2801->1313|2832->1317|2895->1352|2924->1353|2957->1359|3011->1385|3040->1386|3075->1394|3165->1457|3193->1458|3221->1459|3292->1502|3321->1503|3356->1511|3462->1590|3490->1591|3523->1597|3634->1681|3662->1682|3692->1685|3720->1686
                  LINES: 14->1|19->1|20->2|20->2|20->2|20->2|21->3|21->3|21->3|21->3|22->4|25->7|25->7|25->7|26->8|26->8|26->8|26->8|27->9|29->11|29->11|29->11|29->11|29->11|29->11|30->12|32->14|33->15|41->23|41->23|41->23|47->29|48->30|49->31|50->32|50->32|51->33|51->33|51->33|52->34|52->34|52->34|53->35|55->37|55->37|55->37|55->37|55->37|56->38|58->40|58->40|59->41|60->42|60->42|61->43|61->43
                  -- GENERATED --
              */
          