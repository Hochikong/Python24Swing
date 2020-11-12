# Python Tool for Swing

## Currently Tool List:

1. Event Handler Methods Generator: emg

## 1.Event Handler Methods Generator

#### Why

This tool can convert all the swing event handler methods which generated by NetBeans and decorated by 'private'.

You can't change the visibility modifier from 'private' to 'protected' in NetBeans. If you want to use subclass to implements those swing event handler methods, one way is editing their visibility modifier by others editor. Because NetBeans will not allow you change those modifier which generated by IDE automatically. 

The other way is creating a protected method. And put it into the method body of the swing event handler methods.

For example, method below:

```java
class ComboBoxInJava {
    // hidden code
    private void ComboBoxItemStateChanged(ItemEvent evt){
        // TODO
    }
}
```

 You can simply create a protected method. Then put it into previous method' body like this:

```java
class ComboBoxInJava {
    private void ComboBoxItemStateChanged(ItemEvent evt){
        impComboBoxItemStateChanged(ItemEvent evt)
    }

    // hidden code

    protected void impComboBoxItemStateChanged(ItemEvent evt){
        // Do something
    }
}

```

After all these steps have done, you can use subclass to extends the swing code which generated by NetBeans without editing them: 

```kotlin
class ComboBoxInKotlin : ComboBoxInJava() {
    // hidden code
    
    override fun impComboBoxItemStateChanged(evt: ItemEvent){
        // Do what you do
    }
    
    // hidden code
}
```

I recommend you to create swing applications in the style above. No matter what IDE you use,  IDEA's swing designer, NetBeans or JFormDesigner. You can design the GUI by WYSIWYG tool and create empty event handler methods. Then use a subclass to extends and implement all event handler methods in Java codes.

#### How

Use NetBeans to design swing GUI, after create empty event handler methods, use two xml style comments to warp them:
```
    //<Auto-Generate> 
    You Java Code
    //</Auto-Generate>
```

Just like this

```
    //<Auto-Generate>
    private void ComboBoxTargetMetaLibItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxTargetMetaLibItemStateChanged
        impComboBoxTargetMetaLibItemStateChanged(evt);
    }//GEN-LAST:event_ComboBoxTargetMetaLibItemStateChanged

    private void BTNImportFromDiskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNImportFromDiskActionPerformed
        impBTNImportFromDiskActionPerformed(evt);
    }//GEN-LAST:event_BTNImportFromDiskActionPerformed
    //</Auto-Generate>
    
```

Then call the emg to do what you need:

```
C:\Tests>emg -h
usage: emg [-h] [-f xxxx.java] [-p xxxpath]

A simple code generator for NetBeans's to generate 'protected' event handler functions.

optional arguments:
  -h, --help            show this help message and exit
  -f xxxx.java, --file xxxx.java
                        Target java file
  -p xxxpath, --path xxxpath
                        Target path with one or more java files

```

```
C:\Tests>emg -f MetaAdvanceSearch.java
Identified 4 auto generate event methods
Class name: MetaAdvanceSearch
Replacing MetaAdvanceSearch to impMetaAdvanceSearch:
hit rule 4: 'public class MetaAdvanceSearch' -> 'public class impMetaAdvanceSearch'
hit rule 1: 'public MetaAdvanceSearch()' -> 'public impMetaAdvanceSearch()'
hit rule 1: 'public MetaAdvanceSearch()' -> 'public impMetaAdvanceSearch()'
hit rule 2: 'new MetaAdvanceSearch()' -> 'new impMetaAdvanceSearch()'

```

```
C:\Tests>emg -p .
Try to find all java codes:
All 2 java codes found.
Try to analyse these java codes:

Java codes:
-----------------------------
LaunchView.java
MetaAdvanceSearch.java
-----------------------------

Start: ############################

Identified 0 auto generate event methods
Class name: LaunchView
Due to no event handler functions found. No implementation code was generated.

Identified 4 auto generate event methods
Class name: MetaAdvanceSearch
Replacing MetaAdvanceSearch to impMetaAdvanceSearch:
hit rule 4: 'public class MetaAdvanceSearch' -> 'public class impMetaAdvanceSearch'
hit rule 1: 'public MetaAdvanceSearch()' -> 'public impMetaAdvanceSearch()'
hit rule 1: 'public MetaAdvanceSearch()' -> 'public impMetaAdvanceSearch()'
hit rule 2: 'new MetaAdvanceSearch()' -> 'new impMetaAdvanceSearch()'

1 of 2 java codes was generated new code.

End: ############################

```

