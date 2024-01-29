
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object plugins extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[gitbucket.core.plugin.PluginInfoBase],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(plugins: List[gitbucket.core.plugin.PluginInfoBase], info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Plugins")/*2.37*/{_display_(Seq[Any](format.raw/*2.38*/("""
  """),_display_(/*3.4*/gitbucket/*3.13*/.core.admin.html.menu("plugins")/*3.45*/ {_display_(Seq[Any](format.raw/*3.47*/("""
    """),_display_(/*4.6*/gitbucket/*4.15*/.core.helper.html.information(info)),format.raw/*4.50*/("""
    """),format.raw/*5.5*/("""<form action=""""),_display_(/*5.20*/context/*5.27*/.path),format.raw/*5.32*/("""/admin/plugins/_reload" method="POST" class="pull-right">
      <input type="submit" value="Reload plugins" class="btn btn-default">
    </form>
    <h1 class="system-settings-title">Plugins</h1>
    """),_display_(if(plugins.size > 0)/*9.26*/ {_display_(Seq[Any](format.raw/*9.28*/("""
      """),format.raw/*10.7*/("""<ul>
        """),_display_(/*11.10*/plugins/*11.17*/.map/*11.21*/ { plugin =>_display_(Seq[Any](format.raw/*11.33*/("""
          """),format.raw/*12.11*/("""<li><a href="#"""),_display_(/*12.26*/plugin/*12.32*/.pluginId),format.raw/*12.41*/("""">"""),_display_(/*12.44*/plugin/*12.50*/.pluginId),format.raw/*12.59*/(""":"""),_display_(/*12.61*/plugin/*12.67*/.pluginVersion),format.raw/*12.81*/("""</a></li>
        """)))}),format.raw/*13.10*/("""
      """),format.raw/*14.7*/("""</ul>

      """),_display_(/*16.8*/plugins/*16.15*/.map/*16.19*/ { plugin =>_display_(Seq[Any](format.raw/*16.31*/("""
        """),format.raw/*17.9*/("""<div class="panel panel-default">
          <div class="panel-heading strong" id=""""),_display_(/*18.50*/plugin/*18.56*/.pluginId),format.raw/*18.65*/("""">
            <form method="POST" class="pull-right">
              <input type="submit" value="Uninstall" class="btn btn-danger btn-sm uninstall-plugin" style="position: relative; top: -5px; left: 10px;"
                     data-name=""""),_display_(/*21.34*/plugin/*21.40*/.pluginName),format.raw/*21.51*/("""" formaction=""""),_display_(/*21.66*/{context.path}),format.raw/*21.80*/("""/admin/plugins/"""),_display_(/*21.96*/{plugin.pluginId}),format.raw/*21.113*/("""/_uninstall">
            </form>
            """),_display_(/*23.14*/plugin/*23.20*/.pluginName),format.raw/*23.31*/("""
          """),format.raw/*24.11*/("""</div>
          <div class="panel-body">
            <div class="row">
              <label class="col-md-2">Id</label>
              <span class="col-md-10">"""),_display_(/*28.40*/plugin/*28.46*/.pluginId),format.raw/*28.55*/("""</span>
            </div>
            <div class="row">
              <label class="col-md-2">Version</label>
              <span class="col-md-10">"""),_display_(/*32.40*/plugin/*32.46*/.pluginVersion),format.raw/*32.60*/("""</span>
            </div>
            <div class="row">
              <label class="col-md-2">Description</label>
              <span class="col-md-10 muted">"""),_display_(/*36.46*/plugin/*36.52*/.description),format.raw/*36.64*/("""</span>
            </div>
          </div>
        </div>
      """)))}),format.raw/*40.8*/("""
    """)))}else/*41.12*/{_display_(Seq[Any](format.raw/*41.13*/("""
      """),format.raw/*42.7*/("""<p>No plugin detected on your gitbucket installation.</p>
    """)))}),format.raw/*43.6*/("""
  """)))}),format.raw/*44.4*/("""
""")))}),format.raw/*45.2*/("""
"""),format.raw/*46.1*/("""<script>
  $(function()"""),format.raw/*47.15*/("""{"""),format.raw/*47.16*/("""
    """),format.raw/*48.5*/("""$('.uninstall-plugin').click(function(e)"""),format.raw/*48.45*/("""{"""),format.raw/*48.46*/("""
      """),format.raw/*49.7*/("""var name = $(e.target).data('name');
      return confirm('Uninstall ' + name + '. Are you sure?');
    """),format.raw/*51.5*/("""}"""),format.raw/*51.6*/(""");
  """),format.raw/*52.3*/("""}"""),format.raw/*52.4*/(""");
</script>
"""))
      }
    }
  }

  def render(plugins:List[gitbucket.core.plugin.PluginInfoBase],info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(plugins,info)(context)

  def f:((List[gitbucket.core.plugin.PluginInfoBase],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (plugins,info) => (context) => apply(plugins,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/plugins.scala.html
                  HASH: 16d9928ae74fb740b76342c11f1e985e119b8043
                  MATRIX: 665->1|884->128|901->137|935->163|973->164|1002->168|1019->177|1059->209|1098->211|1129->217|1146->226|1201->261|1232->266|1273->281|1288->288|1313->293|1560->514|1599->516|1633->523|1674->537|1690->544|1703->548|1753->560|1792->571|1834->586|1849->592|1879->601|1909->604|1924->610|1954->619|1983->621|1998->627|2033->641|2083->660|2117->667|2157->681|2173->688|2186->692|2236->704|2272->713|2382->796|2397->802|2427->811|2693->1050|2708->1056|2740->1067|2782->1082|2817->1096|2860->1112|2899->1129|2973->1176|2988->1182|3020->1193|3059->1204|3246->1364|3261->1370|3291->1379|3468->1529|3483->1535|3518->1549|3705->1709|3720->1715|3753->1727|3849->1793|3878->1805|3917->1806|3951->1813|4044->1876|4078->1880|4110->1882|4138->1883|4189->1906|4218->1907|4250->1912|4318->1952|4347->1953|4381->1960|4512->2064|4540->2065|4572->2070|4600->2071
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|22->5|22->5|22->5|22->5|26->9|26->9|27->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|29->12|30->13|31->14|33->16|33->16|33->16|33->16|34->17|35->18|35->18|35->18|38->21|38->21|38->21|38->21|38->21|38->21|38->21|40->23|40->23|40->23|41->24|45->28|45->28|45->28|49->32|49->32|49->32|53->36|53->36|53->36|57->40|58->41|58->41|59->42|60->43|61->44|62->45|63->46|64->47|64->47|65->48|65->48|65->48|66->49|68->51|68->51|69->52|69->52
                  -- GENERATED --
              */
          