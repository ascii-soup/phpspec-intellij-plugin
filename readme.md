phpspec support in IntelliJ / PhpStorm
======================================

**Warning**: This plugin is in an alpha state, at best.
There will be bugs and rough edges - you have been warned.

If you are an early adopter and wish to help by testing
 and reporting bugs that's great! Check out the following
 instructions and be sure to read the known bugs section
 as well as any existing issues in the GitHub tracker.

What does it do? (currently-implemented features)
-------------------------------------------------
- basic run configuration so you can run all specs
- run configuration creates missing methods and re-runs specs
- phpspec file type (does nothing but give them an icon, really)
- completes methods from subject on "$this" in spec

Known Bugs / Missing Features
------------------------------
- there is no way to select where your phpspec bin file lives
- sometimes the run configuration will ask you to add a missing method twice
- missing methods added by the run configuration have no arguments
- the run configuration doesn't add missing classes
- the run configuration doesn't report errors in a phpstorm-friendly way
- there is no completion for matchers
- you need to install my branch of phpspec
- needs to be configurable (at least to the same degree as phpspec itself - it should probably read phpspec.yml if any)
- many other things, no doubt...

Planned / Suggested Features
----------------------------
- no bugs!
- complete test runner that has similar power to phpspec on CLI (create classes/methods etc)
- completion for everything - it should know more about phpspec than you do
- typed matcher completion - if IDE can infer the return type of subject method in a spec, it should return typed matchers (count for array, etc) where possible on the first autocomplete, all matchers on second
- inspections / annotations / quick fixes for test smells
- every method covered by specs should have an icon in the gutter that will list all its specs when you click on it
- action to allow switching between spec/subject - this should know which method you are speccing and remember the last spec for this method you were looking at
- option to show expected behaviour for a class in various places (quick documentation? tool window? split editor pane?)
- option to have the project view show specs as children of a subject's file, instead of its members
- probably lots of other stuff..


Installation Instructions
-------------------------

### PhpSpec

Use the "TeamCityFormatter" branch of my [phpspec fork](https://github.com/ascii-soup/phpspec/tree/TeamCityFormatter) for your project:

```
{
    "repositories": [
	       {
	           "type": "vcs",
	           "url": "https://github.com/ascii-soup/phpspec"
	       }
    ],
    "require":
    {
        "phpspec/phpspec": "dev-TeamCityFormatter"
    }
}
```

### Install the plugin

1. Download the file [phpspec-support.jar](phpspec-support.jar) from this repository
2. Open PhpStorm -> Configure -> Plugins -> Install plugin from disk -> select the downloaded jar file.
3. Create a new run configuration - you should see "phpspec" as an option
5. Run!
6. Report bugs here on github: https://github.com/ascii-soup/phpspec-intellij-plugin/issues
