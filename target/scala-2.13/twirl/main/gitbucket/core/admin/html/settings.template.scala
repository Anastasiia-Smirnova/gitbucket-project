
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object settings extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.service.OpenIDConnectService
/*3.2*/import gitbucket.core.util.DatabaseConfig


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("System settings")/*4.45*/{_display_(Seq[Any](format.raw/*4.46*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.admin.html.menu("system")/*5.44*/{_display_(Seq[Any](format.raw/*5.45*/("""
    """),_display_(/*6.6*/gitbucket/*6.15*/.core.helper.html.information(info)),format.raw/*6.50*/("""
    """),format.raw/*7.5*/("""<form action=""""),_display_(/*7.20*/context/*7.27*/.path),format.raw/*7.32*/("""/admin/system" method="POST" validate="true" class="form-horizontal" autocomplete="off">
      <ul class="nav nav-tabs fill-width" id="settings-tab">
        <li><a href="#system">System settings</a></li>
        <li><a href="#integrations">Integrations</a></li>
        <li><a href="#authentication">Authentication</a></li>
      </ul>
      <div class="tab-content fill-width" style="padding-top: 20px;">
        <div class="tab-pane" id="tab-system">
          """),_display_(/*15.12*/settings_system(info)),format.raw/*15.33*/("""
        """),format.raw/*16.9*/("""</div>
        <div class="tab-pane" id="tab-integrations">
          """),_display_(/*18.12*/settings_integrations(info)),format.raw/*18.39*/("""
        """),format.raw/*19.9*/("""</div>
        <div class="tab-pane" id="tab-authentication">
          """),_display_(/*21.12*/settings_authentication(info)),format.raw/*21.41*/("""
        """),format.raw/*22.9*/("""</div>
      </div>
      <hr>
      <div class="align-right" style="margin-top: 20px;">
        <input type="submit" class="btn btn-success" value="Apply changes"/>
      </div>
    </form>
  """)))}),format.raw/*29.4*/("""
""")))}),format.raw/*30.2*/("""
"""),format.raw/*31.1*/("""<script>
$(function()"""),format.raw/*32.13*/("""{"""),format.raw/*32.14*/("""
  """),format.raw/*33.3*/("""function updateTabs()"""),format.raw/*33.24*/("""{"""),format.raw/*33.25*/("""
    """),format.raw/*34.5*/("""$('ul.nav-tabs li').removeClass('active');
    $('div.tab-pane').removeClass('active');

    // Determine active tab from hash
    if(location.hash == '#authentication')"""),format.raw/*38.43*/("""{"""),format.raw/*38.44*/("""
      """),format.raw/*39.7*/("""$('li:has(a[href="#authentication"])').addClass('active');
      $('div#tab-authentication').addClass('active');
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/(""" """),format.raw/*41.7*/("""else if(location.hash == '#integrations')"""),format.raw/*41.48*/("""{"""),format.raw/*41.49*/("""
      """),format.raw/*42.7*/("""$('li:has(a[href="#integrations"])').addClass('active');
      $('div#tab-integrations').addClass('active');
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/(""" """),format.raw/*44.7*/("""else """),format.raw/*44.12*/("""{"""),format.raw/*44.13*/("""
      """),format.raw/*45.7*/("""$('li:has(a[href="#system"])').addClass('active');
      $('div#tab-system').addClass('active');
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/("""
  """),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""

  """),format.raw/*50.3*/("""// Set hash when tab is clicked
  $('#settings-tab li a').click(function(e)"""),format.raw/*51.44*/("""{"""),format.raw/*51.45*/("""
    """),format.raw/*52.5*/("""location.href = $(e.delegateTarget).attr("href");
    updateTabs();
  """),format.raw/*54.3*/("""}"""),format.raw/*54.4*/(""");

  updateTabs();
"""),format.raw/*57.1*/("""}"""),format.raw/*57.2*/(""");
</script>
"""))
      }
    }
  }

  def render(info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(info)(context)

  def f:((Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (info) => (context) => apply(info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/settings.scala.html
                  HASH: 4a859fa5696f1aeea157f341b5cac09b72cc847c
                  MATRIX: 623->1|768->75|826->127|896->170|913->179|955->213|993->214|1022->218|1039->227|1078->258|1116->259|1147->265|1164->274|1219->309|1250->314|1291->329|1306->336|1331->341|1823->806|1865->827|1901->836|1999->907|2047->934|2083->943|2183->1016|2233->1045|2269->1054|2493->1248|2525->1250|2553->1251|2602->1272|2631->1273|2661->1276|2710->1297|2739->1298|2771->1303|2968->1472|2997->1473|3031->1480|3175->1597|3203->1598|3231->1599|3300->1640|3329->1641|3363->1648|3503->1761|3531->1762|3559->1763|3592->1768|3621->1769|3655->1776|3783->1877|3811->1878|3841->1881|3869->1882|3900->1886|4003->1961|4032->1962|4064->1967|4161->2037|4189->2038|4236->2058|4264->2059
                  LINES: 14->1|17->2|18->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|24->7|24->7|24->7|24->7|32->15|32->15|33->16|35->18|35->18|36->19|38->21|38->21|39->22|46->29|47->30|48->31|49->32|49->32|50->33|50->33|50->33|51->34|55->38|55->38|56->39|58->41|58->41|58->41|58->41|58->41|59->42|61->44|61->44|61->44|61->44|61->44|62->45|64->47|64->47|65->48|65->48|67->50|68->51|68->51|69->52|71->54|71->54|74->57|74->57
                  -- GENERATED --
              */
          