
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="main-sidebar">
  <div class="sidebar">
    <ul class="sidebar-menu" id="system-admin-menu-container">
      <li class="menu-item-hover """),_display_(if(active=="users")/*5.54*/{_display_(Seq[Any](format.raw/*5.55*/("""active""")))} else {null} ),format.raw/*5.62*/("""">
        <a href=""""),_display_(/*6.19*/context/*6.26*/.path),format.raw/*6.31*/("""/admin/users">
          <i class="menu-icon octicon octicon-person"></i>
          <span>User management</span>
        </a>
      </li>
      <li class="menu-item-hover """),_display_(if(active=="system")/*11.55*/{_display_(Seq[Any](format.raw/*11.56*/("""active""")))} else {null} ),format.raw/*11.63*/("""">
        <a href=""""),_display_(/*12.19*/context/*12.26*/.path),format.raw/*12.31*/("""/admin/system">
          <i class="menu-icon octicon octicon-gear"></i>
          <span>System settings</span></a>
      </li>
      <li class="menu-item-hover """),_display_(if(active=="plugins")/*16.56*/{_display_(Seq[Any](format.raw/*16.57*/("""active""")))} else {null} ),format.raw/*16.64*/("""">
        <a href=""""),_display_(/*17.19*/context/*17.26*/.path),format.raw/*17.31*/("""/admin/plugins">
          <i class="menu-icon octicon octicon-plug"></i>
          <span>Plugins</span>
        </a>
      </li>
      <li class="menu-item-hover """),_display_(if(active=="data")/*22.53*/{_display_(Seq[Any](format.raw/*22.54*/("""active""")))} else {null} ),format.raw/*22.61*/("""">
        <a href=""""),_display_(/*23.19*/context/*23.26*/.path),format.raw/*23.31*/("""/admin/data">
          <i class="menu-icon octicon octicon-database"></i>
          <span>Data export / import</span>
        </a>
      </li>
      <li class="menu-item-hover """),_display_(if(active=="dbviewer")/*28.57*/{_display_(Seq[Any](format.raw/*28.58*/("""active""")))} else {null} ),format.raw/*28.65*/("""">
        <a href=""""),_display_(/*29.19*/context/*29.26*/.path),format.raw/*29.31*/("""/admin/dbviewer">
          <i class="menu-icon octicon octicon-database"></i>
          <span>Database viewer</span>
        </a>
      </li>
      """),_display_(/*34.8*/gitbucket/*34.17*/.core.plugin.PluginRegistry().getSystemSettingMenus.map/*34.72*/ { menu =>_display_(Seq[Any](format.raw/*34.82*/("""
        """),_display_(/*35.10*/menu(context)/*35.23*/.map/*35.27*/ { link =>_display_(Seq[Any](format.raw/*35.37*/("""
          """),format.raw/*36.11*/("""<li"""),_display_(if(active==link.id)/*36.34*/{_display_(Seq[Any](format.raw/*36.35*/(""" """),format.raw/*36.36*/("""class="active"""")))} else {null} ),format.raw/*36.51*/(""">
            <a href=""""),_display_(/*37.23*/context/*37.30*/.path),format.raw/*37.35*/("""/"""),_display_(/*37.37*/link/*37.41*/.path),format.raw/*37.46*/("""">
              <i class="menu-icon octicon octicon-"""),_display_(/*38.52*/link/*38.56*/.icon.getOrElse("plug")),format.raw/*38.79*/(""""></i>
              <span>"""),_display_(/*39.22*/link/*39.26*/.label),format.raw/*39.32*/("""</span>
            </a>
          </li>
        """)))}),format.raw/*42.10*/("""
      """)))}),format.raw/*43.8*/("""
   """),format.raw/*44.4*/("""</ul>
  </div>
</div>
<div class="content-wrapper">
  <div class="content body">
    """),_display_(/*49.6*/body),format.raw/*49.10*/("""
  """),format.raw/*50.3*/("""</div>
</div>
"""))
      }
    }
  }

  def render(active:String,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active)(body)(context)

  def f:((String) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active) => (body) => (context) => apply(active)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/menu.scala.html
                  HASH: ba4a3057a62c96abcd9e5bb711687f1747a83216
                  MATRIX: 619->1|794->83|987->250|1025->251|1075->258|1122->279|1137->286|1162->291|1381->483|1420->484|1471->491|1519->512|1535->519|1561->524|1771->707|1810->708|1861->715|1909->736|1925->743|1951->748|2160->930|2199->931|2250->938|2298->959|2314->966|2340->971|2567->1171|2606->1172|2657->1179|2705->1200|2721->1207|2747->1212|2923->1362|2941->1371|3005->1426|3053->1436|3090->1446|3112->1459|3125->1463|3173->1473|3212->1484|3262->1507|3301->1508|3330->1509|3389->1524|3440->1548|3456->1555|3482->1560|3511->1562|3524->1566|3550->1571|3631->1625|3644->1629|3688->1652|3743->1680|3756->1684|3783->1690|3864->1740|3902->1748|3933->1752|4045->1838|4070->1842|4100->1845
                  LINES: 14->1|19->2|22->5|22->5|22->5|23->6|23->6|23->6|28->11|28->11|28->11|29->12|29->12|29->12|33->16|33->16|33->16|34->17|34->17|34->17|39->22|39->22|39->22|40->23|40->23|40->23|45->28|45->28|45->28|46->29|46->29|46->29|51->34|51->34|51->34|51->34|52->35|52->35|52->35|52->35|53->36|53->36|53->36|53->36|53->36|54->37|54->37|54->37|54->37|54->37|54->37|55->38|55->38|55->38|56->39|56->39|56->39|59->42|60->43|61->44|66->49|66->49|67->50
                  -- GENERATED --
              */
          